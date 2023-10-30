def solution(players, callings):
    players_dict = {}
    for i, player in enumerate(players):
        players_dict[player] = i

    for player in callings:
        idx = players_dict[player]
        players_dict[player] -= 1
        players_dict[players[idx-1]] += 1
        players[idx-1], players[idx] = players[idx], players[idx-1]
        
    return players