
from maze_follower import step, traverse

easy = [
    "WWWWWWWWWWW",
    "WS        W",
    "WWWWWWWWW W",
    "W         W",
    "WEWWWWWWWWW",
    "WWW"
]

medium = [
    "WWWWWWWWWWW",
    "WS    W   W",
    "WWWWW W W W",
    "W   W   W W",
    "W W W WWW W",
    "W W W WWW W",
    "W W WWWWW W",
    "W W     W W",
    "WEWWWWW   W",
    "WWWWWWWWWWW"
]

hard = []

maze = medium

result, breadcrums = traverse(maze, step)

print("After", breadcrums, "steps, victory was achieved!")
print("Here is the path I took:")
for line in maze:
    print(line)