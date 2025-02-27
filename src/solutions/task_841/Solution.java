package solutions.task_841;

import java.util.List;

/**
 * 841. Keys and Rooms
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal
 * is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] roomOpened = new boolean[rooms.size()];
        roomOpened[0] = true;

        List<Integer> keys = rooms.getFirst();
        visit(rooms, keys, roomOpened);

        for (boolean b : roomOpened) {
            if (!b) return false;
        }
        return true;
    }

    private void visit(List<List<Integer>> rooms, List<Integer> keys, boolean[] roomOpened) {

        for (Integer roomKey : keys) {
            if (!roomOpened[roomKey]) {
                roomOpened[roomKey] = true;
                visit(rooms, rooms.get(roomKey), roomOpened);
            }
        }
    }
}