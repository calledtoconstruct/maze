module Types where
  type Position = (Int, Int)
  type MazePosition = (Char, Position)
  type RelativeMazePosition = (Char, Position, Position)
  type Maze = [String]
  data Result = MazeComplete Maze | NoStart | NoEnd | NoPath deriving (Eq)

  instance Show Result where
    show (MazeComplete x) = "MAZE WAS COMPLETED\n" ++ unlines x
    show NoStart          = "Start is Missing!"
    show NoEnd            = "End is Missing!"
    show NoPath           = "There is no path from Start to End!"
