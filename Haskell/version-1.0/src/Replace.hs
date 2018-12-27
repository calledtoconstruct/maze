module Replace (
  replaceInLine,
  replaceInMaze
) where

  import Enumerate
  import Maze

  replaceInLine :: Int -> Int -> Char -> Int -> String -> String
  replaceInLine replaceX replaceY newValue y line = map
    (\(x, value) -> if replaceX == x && replaceY == y then newValue else value)
    $ enumerate line

  replaceInMaze :: Maze -> Int -> Int -> Char -> Maze
  replaceInMaze maze replaceX replaceY newValue = map
    (\(y, line) -> replaceInLine replaceX replaceY newValue y line)
    $ enumerate maze
