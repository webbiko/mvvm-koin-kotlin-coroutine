package br.com.kotlincoroutine.presentation.todos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kotlincoroutine.R
import br.com.kotlincoroutine.domain.model.todos.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(todo: Todo) {
        itemView.taskId.text = "${todo.id}"
        itemView.taskDescription.text = todo.task
    }

    companion object {
        fun create(parent: ViewGroup) : TodoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_item_layout, parent, false)

            return TodoViewHolder(view)
        }
    }
}