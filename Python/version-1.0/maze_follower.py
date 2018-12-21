"#" 

def test():
    return 100

def step(maze, x, y):
    start = 0
    end = 0
    for line in maze:
        if "S" in line:
            start = start + 1
        if "E" in line:
            end = end + 1
    if start == 0 or end == 0:
        raise ValueError()
    y = 0       
    for line in maze:
        y = y + 1
        
    return "S", 1, 0
