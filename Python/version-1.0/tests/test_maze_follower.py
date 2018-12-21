"#" 

from maze_follower import test, step

def test_test():
    result = test()
    assert(result == 100)

def test_given_i_have_received_a_board_that_is_missing_a_start_position_when_evaluating_then_an_exception_is_thrown():
    maze = "E"
    try:
        result = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_board_that_is_missing_an_end_position_when_evaluating_then_an_exception_is_thrown():
    maze = "S"
    try:
        result = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_valid_board_when_stepping_then_no_error_is_thrown():
    maze = "SE"
    result = step(maze)
    assert(False)