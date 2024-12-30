const API_BASE_URL = 'http://localhost:8080/api/todos';

// Initialize state
const state = {
    todos: [],
    currentPriority: 'high',
    currentFilter: 'all',
    theme: 'light'
};

// Fetch todos from backend
async function fetchTodos() {
    try {
        const response = await fetch(API_BASE_URL);
        if (!response.ok) {
            throw new Error('Failed to fetch todos');
        }
        const todos = await response.json();
        state.todos = todos;
        renderTodos();
    } catch (error) {
        console.error('Error fetching todos:', error);
    }
}

// Add todo
async function addTodo() {
    const input = document.getElementById('todoInput');
    const text = input.value.trim();
    
    if (text) {
        try {
            const response = await fetch(API_BASE_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    text: text,
                    priority: state.currentPriority,
                    completed: false
                })
            });

            if (!response.ok) {
                throw new Error('Failed to add todo');
            }

            input.value = '';
            await fetchTodos(); // Refresh the list
        } catch (error) {
            console.error('Error adding todo:', error);
        }
    }
}

// Toggle todo completion
async function toggleComplete(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/${id}/toggle`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Failed to toggle todo');
        }

        await fetchTodos(); // Refresh the list
    } catch (error) {
        console.error('Error toggling todo:', error);
    }
}

// Delete todo
async function deleteTodo(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            throw new Error('Failed to delete todo');
        }

        await fetchTodos(); // Refresh the list
    } catch (error) {
        console.error('Error deleting todo:', error);
    }
}

// Theme toggle
function toggleTheme() {
    state.theme = state.theme === 'light' ? 'dark' : 'light';
    document.documentElement.setAttribute('data-theme', state.theme);
}

// Set priority
function setPriority(priority) {
    state.currentPriority = priority;
    document.querySelectorAll('.priority-btn').forEach(btn => {
        btn.classList.toggle('active', btn.dataset.priority === priority);
    });
}

// Filter todos
function filterTodos(filter) {
    state.currentFilter = filter;
    document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.classList.toggle('active', btn.textContent.toLowerCase() === filter);
    });
    renderTodos();
}

// Render todos
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
            <button class="btn complete-btn" onclick="toggleComplete('${todo.id}')">✓</button>
            <div class="todo-content">
                <span class="todo-text">${todo.text}</span>
                <span class="todo-meta">Created: ${new Date(todo.createdAt).toLocaleString()}</span>
            </div>
            <button class="btn delete-btn" onclick="deleteTodo('${todo.id}')">×</button>
        `;
        
        todoList.appendChild(todoItem);
    });
    
    updateStats();
}

// Update statistics
function updateStats() {
    const totalCount = state.todos.length;
    const completedCount = state.todos.filter(t => t.completed).length;
    const progressPercent = totalCount === 0 ? 0 : Math.round((completedCount / totalCount) * 100);
    
    document.getElementById('totalCount').textContent = totalCount;
    document.getElementById('completedCount').textContent = completedCount;
    document.getElementById('progressPercent').textContent = `${progressPercent}%`;
}

// Initialize application
document.addEventListener('DOMContentLoaded', function() {
    // Set up event listeners
    document.getElementById('todoInput').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            addTodo();
        }
    });

    // Load initial todos
    fetchTodos();
});