module Main where

import Lib
import Types

medium :: [String]
medium = [
    "WWWWWWWWWWW",
    "WS    W   W",
    "WWWWW W W W",
    "W   W   W W",
    "W W WWWWW W",
    "W W WWWWW W",
    "W W WWWWW W",
    "W W     W W",
    "WEWWWWW   W",
    "WWWWWWWWWWW"
  ]

large :: [String]
large = [
    "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW",
    "WS    W                                                                                W",
    "WWWWW WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W",
    "W   W W                                                                              W W",
    "W W W W WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W",
    "W W W W                                                                  W             W",
    "W W W W W WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W WWWWWWWWWWWWW",
    "W W W W W W       W                 W                                  W W             W",
    "W W   W W W WWWWW WWWWWWWWWWWWWWWWW W WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W W WWWWWWWWWWWWW W",
    "W WWWWW W W     W                   W                              W W W             W W",
    "W     W W WWWWW WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W W WWWWWWWWWWWWW W W",
    "WWWWW W W W                                      W   W   W   W   W W W     W   W   W W W",
    "W     W W W WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW W W W W W W W W W WWWWW W W W W W W W",
    "W WWWWW W W                                        W   W   W   W   W     W   W   W   W W",
    "W       W W WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW WWW WWWWWWWWWWWWW W",
    "WWWWWWWWW W W                                                        WWW    W        W W",
    "WWWWWWWWWWW WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW WWW",
    "WE                                                                                     W",
    "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"
  ]

main :: IO ()
main = print $ run large
