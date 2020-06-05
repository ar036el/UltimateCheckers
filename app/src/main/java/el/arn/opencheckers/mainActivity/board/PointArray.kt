package el.arn.opencheckers.mainActivity.board

import el.arn.opencheckers.checkers_game.game_core.structs.Point


class PointArray<T>(private val size: Int, init: (Point) -> T) {
    private val array = Array(size) {
        x -> Array<Any?>(size) { y -> init(Point(x, y)) }
    }

    operator fun get(x: Int, y: Int): T {
        return array[x][y] as T
    }

    operator fun get(point: Point): T {
        return array[point.x][point.y] as T
    }

    operator fun set(x: Int, y: Int, value: T) {
        array[x][y] = value
    }

    operator fun set(point: Point, value: T) {
        array[point.x][point.y] = value
    }

    fun indexOf(item: T): Point? {
        for (x in array.indices) {
            for (y in array[x].indices) {
                if (array[x][y] == item) {
                    return Point(x,y)
                }
            }
        }
        return null
    }
}