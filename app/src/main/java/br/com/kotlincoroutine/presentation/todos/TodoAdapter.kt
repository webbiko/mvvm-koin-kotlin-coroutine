package br.com.kotlincoroutine.presentation.todos

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kotlincoroutine.domain.model.todos.Todo

class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {

    private var todos = emptyList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder.create(parent)

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) =
        holder.bind(todos[holder.adapterPosition])

    override fun getItemCount(): Int = todos.size

    fun setData(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
}