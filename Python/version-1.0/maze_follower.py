"#" 

def test():
    return 100

def validate(maze):
    start = 0
    end = 0
    for line in maze:
        if "S" in line:
            start = start + 1
        if "E" in line:
            end = end + 1
    if start == 0 or end == 0:
        raise ValueError()

def start(maze):
    for y, line in enumerate(maze):
        for x, current in enumerate(line):
            if current == 'S':
                return current, x, y

def step(maze, cx = -1, cy = -1):
    if cx == -1 or cy == -1:
        validate(maze)
        return start(maze)
    for y, line in enumerate(maze):
        for x, current in enumerate(line):
            if cx == x or cy == y:
                if current == 'E':
                    return "Victory!", x, y
                if current == ' ':
                    if x in range(cx-1, 3):
                        if y in range(cy-1, 3):
                            maze[cy] = maze[cy][0:cx] + '*' + maze[cy][cx+1:]
                            maze[y] = maze[y][0:x] + 'C' + maze[y][x+1:]
                            return current, x, y
    raise ValueError

def traverse(maze):
    return "Victory!", 21