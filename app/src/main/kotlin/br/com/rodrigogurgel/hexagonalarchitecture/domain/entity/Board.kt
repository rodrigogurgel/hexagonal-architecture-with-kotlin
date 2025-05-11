package br.com.rodrigogurgel.hexagonalarchitecture.domain.entity

import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.DuplicatedTaskException
import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.TasksNotFoundException
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Name

data class Board(
    val id: Id,
    var name: Name,
) {
    constructor(id: Id, name: Name, tasks: List<Task>) : this(id, name) {
        this.tasks = tasks.toMutableList()
    }

    private lateinit var mutableTaskMap: MutableMap<Id, Task>

    var tasks: MutableList<Task>
        get() = mutableTaskMap.values.toMutableList()
        set(value) {
            mutableTaskMap = value.associateBy { it.id }.toMutableMap()
        }

    fun addTask(task: Task) = addTasks(tasks = listOf(task))
    fun removeTask(id: Id) = removeTasks(ids = listOf(id))
    fun updateTask(task: Task) = updateTasks(tasks = listOf(task))

    fun addTasks(tasks: List<Task>) {
        this.tasks.addAll(tasks)
        val duplicateTasks = this.tasks.groupBy { it.id }.filter { it.value.size > 1 }
        if (duplicateTasks.isNotEmpty()) throw DuplicatedTaskException(ids = duplicateTasks.keys)
    }

    fun removeTasks(ids: List<Id>) {
        this.tasks.removeIf { it.id in ids }
    }

    fun updateTasks(tasks: List<Task>) {
        val ids = this.tasks.map { task -> task.id }
        val notFoundIds = tasks.filterNot { id in ids }.map { task -> task.id }

        if (notFoundIds.isNotEmpty()) throw TasksNotFoundException(notFoundIds)

        tasks.forEach { task ->
            if (mutableTaskMap.containsKey(task.id)) {
                mutableTaskMap[task.id] = task
            }
        }
    }
}
