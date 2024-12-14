// Initialize state
const state = {
    todos: [],
    currentPriority: 'high',
    currentFilter: 'all',
    theme: 'light'
};

// Wait for DOM to load
document.addEventListener('DOMContentLoaded', function() {
    // Initialize event listener
    document.getElementById('todoInput').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            addTodo();
        }
    });

    // Initial render
    renderTodos();
});

function toggleTheme() {
    state.theme = state.theme === 'light' ? 'dark' : 'light';
    document.documentElement.setAttribute('data-theme', state.theme);
}

function setPriority(priority) {
    state.currentPriority = priority;
    document.querySelectorAll('.priority-btn').forEach(btn => {
        btn.classList.toggle('active', btn.dataset.priority === priority);
    });
}

function filterTodos(filter) {
    state.currentFilter = filter;
    document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.classList.toggle('active', btn.textContent.toLowerCase() === filter);
    });
    renderTodos();
}

function addTodo() {
    const input = document.getElementById('todoInput');
    const text = input.value.trim();
    
    if (text) {
        const todo = {
            id: Date.now(),
            text: text,
            completed: false,
            priority: state.currentPriority,
            createdAt: new Date().toLocaleString()
        };
        
        state.todos.unshift(todo);
        renderTodos();
        input.value = '';
    }
}

function toggleComplete(id) {
    const todo = state.todos.find(t => t.id === id);
    if (todo) {
        todo.completed = !todo.completed;
        renderTodos();
    }
}

function deleteTodo(id) {
    state.todos = state.todos.filter(t => t.id !== id);
    renderTodos();
}

function renderTodos() {
    const todoList = document.getElementById('todoList');
    
    let filteredTodos = state.todos;
    if (state.currentFilter === 'active') {
        filteredTodos = state.todos.filter(t => !t.completed);
    } else if (state.currentFilter === 'completed') {
        filteredTodos = state.todos.filter(t => t.completed);
    }
    
    if (filteredTodos.length === 0) {
        todoList.innerHTML = '<div class="empty-state">No tasks found</div>';
        updateStats();
        return;
    }

    todoList.innerHTML = '';
    
    filteredTodos.forEach(todo => {
        const todoItem = document.createElement('div');
        todoItem.className = `todo-item priority-${todo.priority} ${todo.completed ? 'completed' : ''}`;
        
        todoItem.innerHTML = `
            <button class="btn complete-btn" onclick="toggleComplete(${todo.id})">✓</button>
            <div class="todo-content">
                <span class="todo-text">${todo.text}</span>
                <span class="todo-meta">Created: ${todo.createdAt}</span>
            </div>
            <button class="btn delete-btn" onclick="deleteTodo(${todo.id})">×</button>
        `;
        
        todoList.appendChild(todoItem);
    });
    
    updateStats();
}

function updateStats() {
    const totalCount = state.todos.length;
    const completedCount = state.todos.filter(t => t.completed).length;
    const progressPercent = totalCount === 0 ? 0 : Math.round((completedCount / totalCount) * 100);
    
    document.getElementById('totalCount').textContent = totalCount;
    document.getElementById('completedCount').textContent = completedCount;
    document.getElementById('progressPercent').textContent = `${progressPercent}%`;
}