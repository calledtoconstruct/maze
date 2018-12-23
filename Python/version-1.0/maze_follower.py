"#" 

def test():
    return 100

def step(maze, cx = -1, cy = -1):
    start = 0
    end = 0
    for line in maze:
        if "S" in line:
            start = start + 1
        if "E" in line:
            end = end + 1
    if start == 0 or end == 0:
        raise ValueError()
    if cx == -1 or cy == -1:
        for y, line in enumerate(maze):
            for x, current in enumerate(line):
                if current == 'S':
                    return current, x, y
    for y, line in enumerate(maze):
        for x, current in enumerate(line):
            if current == ' ':
                if x in range(cx-1, 3):
                    if y in range(cy-1, 3):
                        maze[cy] = maze[cy][0:x] + '*' + maze[cy][x+1:]
                        return current, x, y
    raise ValueError
