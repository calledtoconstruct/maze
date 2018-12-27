module Maze where
  type Maze = [String]
  data Result = MazeComplete Maze | NoStart | NoEnd | NoPath deriving (Show)
