module Enumerate (
  enumerate
) where
  enumerate :: [a] -> [(Int, a)]
  enumerate = zip [0..]
