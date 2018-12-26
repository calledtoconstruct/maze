
from maze_follower import step, traverse

def test_given_i_have_received_a_board_that_is_missing_a_start_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["E"]
    try:
        result, x, y, options = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_board_that_is_missing_an_end_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["S"]
    try:
        result, x, y, options = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_valid_board_when_stepping_then_no_error_is_thrown():
    maze = ["SE"]
    result, x, y, options = step(maze)
    assert(True)

def test_given_i_have_received_a_valid_board_with_multiple_lines_when_stepping_then_no_error_is_thrown():
    maze = ["S","E"]
    result, x, y, options = step(maze)
    assert(True)

def test_given_an_unnavigated_board_when_stepping_then_the_start_position_is_returned():
    maze = [
        "WS",
        "WE"
    ]
    result, x, y, options = step(maze)
    assert(result == "S")
    assert(x == 1)
    assert(y == 0)

def test_given_i_am_at_a_known_location_when_stepping_then_the_position_of_the_empty_space_is_returned():
    scenario = [
        ( [ "WS", "W E" ], 1, 0, 1, 1 ),
        ( [ "WWE", "W W", "W S" ], 2, 2, 1, 2 )
    ]
    for current in scenario:
        maze, sx, sy, ex, ey = current
        result, x, y, options = step(maze, sx, sy)
        assert(result == " ")
        assert(x == ex)
        assert(y == ey)

def test_given_i_am_at_a_known_location_when_stepping_then_an_error_is_raised():
    maze = [
        "WSW",
        "WWE"
    ]
    try:
        result, x, y, options = step(maze, 1, 0)
        assert(False)
    except ValueError:
        return

def test_given_i_am_at_a_known_location_when_stepping_then_the_location_i_move_from_is_filled_with_a_breadcrum():
    maze = [
        "WSW",
        "W E"
    ]
    result, x, y, options = step(maze, 1, 0)
    assert(maze[0][1] == '*')
    maze = [
        "WS W",
        "WWE"
    ]
    result, x, y, options = step(maze, 1, 0)
    assert(maze[0][1] == '*')

def test_given_i_am_at_a_known_location_when_stepping_then_the_location_i_move_to_is_filled_with_a_current_position_marker():
    maze = [
        "WSW",
        "W E"
    ]
    result, x, y, options = step(maze, 1, 0)
    assert(maze[y][x] == 'C')

def test_given_i_am_at_a_known_location_and_the_endpoint_is_adjacent_when_stepping_then_victory_and_the_position_of_the_endpoint_is_returned():
    maze = [
        "W*W",
        "WCE"
    ]
    result, x, y, options = step(maze, 1, 1)
    assert(result == "Victory!")
    assert(x == 2)
    assert(y == 1)

def test_given_a_valid_maze_when_enumerating_each_step_then_victory_is_achieved():
    maze = [
        "WWWWWWWWWWWW",
        "WS         W",
        "WWWWWWWWWW W",
        "W          W",
        "WEWWWWWWWWWW",
        "WWW"
    ]
    result, breadcrums = traverse(maze, step)
    assert(result == "Victory!")
    assert(breadcrums == 21)

step_called = False

def my_step(maze, x = -1, y = -1):
    global step_called
    step_called = True
    return "Victory!", 100, 200, []

def test_given_a_valid_maze_when_enumerating_each_step_then_the_step_method_is_invoked():
    global step_called
    maze = [
        "WWWWWWWWWWW",
        "WS        W",
        "WWWWWWWWW W",
        "W         W",
        "WEWWWWWWWWW",
        "WWW"
    ]
    traverse(maze, my_step)
    assert(step_called == True)

def test_given_i_am_at_a_known_location_and_two_options_exist_when_stepping_then_the_first_option_is_chosen_and_the_other_option_is_returned():
    scenarios = [
        ([ "W*WW", "WC W", "W WW", "WEWW", "WWWW" ], 1, 1, 2, 1, 1, 1, 2),
        ([ "WW*WW", "W C W", "W W W", "WEWWW", "WWWW" ], 2, 1, 1, 1, 1, 3, 1)
    ]
    for maze, cx, cy, nx, ny, l, fox, foy in scenarios:
        result, x, y, options = step(maze, cx, cy)
        assert(result == " ")
        assert(x == nx)
        assert(y == ny)
        assert(len(options) == l)
        assert(options[0] == (fox, foy))
