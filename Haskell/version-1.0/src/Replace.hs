module Replace (
  replaceInLine,
  replaceInMaze
) where

  import Enumerate
  import Types

  replaceInLine :: Position -> Char -> Int -> String -> String
  replaceInLine replace newValue y line = map
    (\(x, value) -> if replaceX == x && replaceY == y then newValue else value)
    $ enumerate line
    where (replaceX, replaceY) = replace

  replaceInMaze :: Maze -> Position -> Char -> Maze
  replaceInMaze maze replace newValue = map
    (\(y, line) -> replaceInLine replace newValue y line)
    $ enumerate maze
