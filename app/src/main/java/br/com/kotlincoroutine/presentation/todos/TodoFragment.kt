package br.com.kotlincoroutine.presentation.todos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import br.com.kotlincoroutine.R
import br.com.kotlincoroutine.presentation.common.BaseFragment
import br.com.kotlincoroutine.utils.EventObserver
import kotlinx.android.synthetic.main.todo_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.todo_fragment

    private val viewModel: TodoViewModel by viewModel()

    private lateinit var todoAdapter: TodoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todosRecyclerView.itemAnimator = DefaultItemAnimator()
        todoAdapter = TodoAdapter()
        todosRecyclerView.adapter = todoAdapter


        viewModel.todoSuccess.observe(viewLifecycleOwner, EventObserver {todos ->
            todoAdapter.setData(todos)
        })

        viewModel.todoEmpty.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), "Nenhuma task encontrada!", Toast.LENGTH_LONG).show()
        })

        viewModel.todoError.observe(viewLifecycleOwner, EventObserver { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })

        viewModel.loadTodoList()
    }
}