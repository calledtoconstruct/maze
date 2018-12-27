module Find (
  find,
  findRelative
) where

import Enumerate
import Maze

findInLine :: ((Char, Int, Int) -> Bool) -> Int -> String -> [(Char, Int, Int)]
findInLine predicate y line = filter predicate $ map
  (\(x, value) -> (value, x, y))
  $ enumerate line

find :: ((Char, Int, Int) -> Bool) -> Maze -> [[(Char, Int, Int)]]
find predicate maze = map
  (\(y, line) -> findInLine predicate y line)
  $ enumerate maze

findRelativeInLine :: ((Char, Int, Int, Int, Int) -> Bool) -> Int -> Int -> Int -> String -> [(Char, Int, Int, Int, Int)]
findRelativeInLine next cx cy y line = filter next $ map
  (\(x, value) -> (value, cx, cy, x, y))
  $ enumerate line

findRelative :: ((Char, Int, Int, Int, Int) -> Bool) -> Maze -> Int -> Int -> [[(Char, Int, Int, Int, Int)]]
findRelative next maze cx cy = map
  (\(y, line) -> findRelativeInLine next cx cy y line)
  $ enumerate maze
