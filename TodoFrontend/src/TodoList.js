import { useEffect, useState } from "react";
import axios from "axios";

export default function TodoList() {

    // State to hold ToDo items
    const [todos, setTodos] = useState([]);

    const formatDateTime = (dateString) => {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0'); // Month is 0-indexed
        const day = String(date.getDate()).padStart(2, '0');
        const hours = String(date.getHours()).padStart(2, '0');
        const minutes = String(date.getMinutes()).padStart(2, '0');
        const seconds = String(date.getSeconds()).padStart(2, '0');
        return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    };

    
    const fetchTodos = async () => {
        try {
            const response = await axios.get('http://localhost:8083/api/todo/all');
            setTodos(response.data);
        } catch (error) {
            console.error('Error fetching ToDo items', error);
        }
    };

    // Use fetchTodos inside useEffect to fetch ToDo items when component loads
    useEffect(() => {
        fetchTodos();
    }, []);

    // Submit new ToDo item to the API
    const handleSubmit = async (event) => {
        event.preventDefault();

        let task = event.target.task.value;
        if (!task) {
            alert("Please provide a valid task");
            return;
        }

        const newTodo = {
            item: task,
            status: false, 
        };

        



        try {
            await axios.post('http://localhost:8083/api/todo/save', newTodo);
            // Refresh the ToDo list after adding a new one
            fetchTodos();
        } catch (error) {
            console.error('Error saving ToDo item', error);
        }

        event.target.reset();
    };

    // Change the task completion status by calling the backend
    const changeTaskStatus = async (index, id) => {
        try {
            await axios.put(`http://localhost:8083/api/todo/${id}/status`);
            fetchTodos(); // Refresh the ToDo list after update
        } catch (error) {
            console.error('Error updating ToDo status', error);
        }
    };

    // Delete the ToDo item by calling the backend
    const deleteTask = async (id) => {
        try {
            await axios.delete(`http://localhost:8083/api/todo/${id}`);
            fetchTodos(); 
        } catch (error) {
            console.error('Error deleting ToDo item', error);
        }
    };

    return (
        <div className="container my-5">
            <div
                className="mx-auto rounded border p-4"
                style={{ width: "600px", backgroundColor: "#08618d" }}
            >
                <h2 className="text-white text-center mb-5">To-Do List</h2>

                <form className="d-flex" onSubmit={handleSubmit}>
                    <input
                        className="form-control me-2"
                        placeholder="New Task"
                        name="task"
                    />
                    <button className="btn btn-outline-light" type="submit">
                        Add
                    </button>
                </form>

                {todos.map((todo, index) => {
                    console.log(todo)
                    return (
                        <div
                            key={index}
                            className="rounded mt-4 p-2 d-flex"
                            style={{
                                backgroundColor: todo.status == "Completed" ? "#87FC68" : "LightGray",
                            }}
                        >
                            <div className="me-auto">
                                <div>{todo.item}</div>
                                {/* <div>{todo.createdAt}</div> */}

                                <div className="text-muted" style={{ fontSize: '0.8em' }}>
                                    { formatDateTime(todo.createdAt)}
                                </div>
                            </div>

                            <div>
                                <i
                                    className={
                                        "h5 me-2" + (todo.status == "Completed"
                                            ? "bi bi-check2-circle"
                                            : "bi bi-circle")
                                    }
                                    style={{ cursor: "pointer" }}
                                    onClick={() => changeTaskStatus(index, todo.id)}
                                ></i>
                                <i
                                    className="bi bi-trash text-danger h5"
                                    style={{ cursor: "pointer" }}
                                    onClick={() => deleteTask(todo.id)}
                                ></i>
                            </div>
                        </div>
                    );
                })}
            </div>
        </div>
    );
}
