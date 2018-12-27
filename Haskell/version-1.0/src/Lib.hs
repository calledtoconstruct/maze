module Lib ( run ) where

type Maze = [String]
data Result = MazeComplete Maze | NoStart | NoEnd | NoPath deriving (Show)

enumerate :: [a] -> [(Int, a)]
enumerate = zip [0..]

findInLine :: ((Char, Int, Int) -> Bool) -> Int -> String -> [(Char, Int, Int)]
findInLine predicate y line = filter predicate $ map (\(x, value) -> (value, x, y)) $ enumerate line

findInMaze :: ((Char, Int, Int) -> Bool) -> Maze -> [[(Char, Int, Int)]]
findInMaze predicate maze = map (\(y, line) -> findInLine predicate y line) $ enumerate maze

has :: ((Char, Int, Int) -> Bool) -> Maze -> Bool
has predicate maze = (==) 1 $ length $ concat $ findInMaze predicate maze

start :: (Char, Int, Int) -> Bool
start (value, _, _) = value == 'S'

end :: (Char, Int, Int) -> Bool
end (value, _, _) = value == 'E'

filterNext :: (Char, Int, Int, Int, Int) -> Bool
filterNext (value, cx, cy, x, y) = (value == 'E' || value == ' ') && ((abs(x - cx) == 1 && cy == y) || (abs(y - cy) == 1 && cx == x))

findNextInLine :: Int -> Int -> Int -> String -> [(Char, Int, Int, Int, Int)]
findNextInLine cx cy y line = filter filterNext $ map (\(x, value) -> (value, cx, cy, x, y)) $ enumerate line

findNextInMaze :: Maze -> Int -> Int -> [[(Char, Int, Int, Int, Int)]]
findNextInMaze maze cx cy = map (\(y, line) -> findNextInLine cx cy y line) $ enumerate maze

hasNext :: Maze -> Int -> Int -> Bool
hasNext maze cx cy = (==) 1 $ length $ concat $ findNextInMaze maze cx cy

replaceInLine :: Int -> Int -> Char -> Int -> String -> String
replaceInLine cx cy nv y line = map (\(x, value) -> if cx == x && cy == y then nv else value) $ enumerate line

replaceInMaze :: Maze -> Int -> Int -> Char -> Maze
replaceInMaze maze cx cy nv = map (\(y, line) -> replaceInLine cx cy nv y line) $ enumerate maze

leaveBreadcrumb :: Maze -> Int -> Int -> Maze
leaveBreadcrumb maze x y = replaceInMaze maze x y '*'

atTheEnd :: Maze -> Int -> Int -> Bool
atTheEnd maze x y = ex == x && ey == y
  where (v, ex, ey) = head $ concat $ findInMaze end maze

move :: Maze -> Int -> Int -> Result
move maze cx cy = if hasNext maze cx cy
  then move updated nx ny
  else if atTheEnd maze cx cy then MazeComplete updated
  else NoPath
  where (v, _, _, nx, ny) = head $ concat $ findNextInMaze updated cx cy
        updated = leaveBreadcrumb maze cx cy

run :: Maze -> Result
run maze = if has start maze && has end maze && hasNext maze sx sy
    then move maze sx sy
    else if has start maze
    then NoEnd
    else NoStart
    where (v, sx, sy) = head $ concat $ findInMaze start maze
