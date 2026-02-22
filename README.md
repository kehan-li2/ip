# Yuzu Chatbot - User Guide 🪽

**Yuzu** is a lightweight, text-based task management assistant designed to help you stay up with your daily schedule with ease!

---

## Quick Start
1. Ensure you have **Java 17** or higher installed on your computer.
2. Open your terminal or command prompt.
3. Run the chatbot using: `java -jar yuzu.jar`
4. Type your command and press **Enter**!

---

## Features 

### 1. Adding Tasks
Yuzu helps you track three different types of tasks:

* **Todo**: A simple task without any date.
    * **Format**: `todo DESCRIPTION`
    * **Example**: `todo Read a book`
* **Deadline**: A task that needs to be finished by a specific date.
    * **Format**: `deadline DESCRIPTION /by YYYY-MM-DD`
    * **Example**: `deadline Return library book /by 2026-03-01`
* **Event**: A task that occurs on specific date with a time period.
    * **Format**: `event DESCRIPTION /on YYYY-MM-DD /from HH:mm /to HH:mm`
    * **Example**: `event Project meeting /on 2026-03-01 /from 14:00 /to 16:00`

### 2. Manage Your Tasks
* **List Tasks**: See all your tasks in one list.
    * **Command**: `list`
* **Mark as Done**: Mark a task be completed after you finish it.
    * **Command**: `mark INDEX` (eg. `mark 1`)
* **Unmark**: Mark a task as not done.
    * **Command**: `unmark INDEX`
* **Delete Tasks**: Remove a task from your list.
    * **Command**: `delete INDEX`

### 3. Find && Filter Tasks 
* **Search by Keyword**: Find tasks that contain a specific word in the description.
    * **Command**: `find KEYWORD`
* **Check Due Date**: Find tasks that due on a specific date.
    * **Command**: `due on YYYY-MM-DD`

### 4. Snooze Tasks (Postpone)
Want to change your task date? Reschedule your deadlines or events to another date.
* **Format**: `snooze INDEX /to YYYY-MM-DD`
* **Example**: `snooze 2 /to 2026-03-12`

---

# Command Summary Table

| Action       | Format                                                           |
|--------------|------------------------------------------------------------------|
| Add Todo     | `todo <description>`                                             |
| Add Deadline | `deadline <description> /by <YYYY-MM-DD>`                        |
| Add Event    | `event <description> /on <YYYY-MM-DD> /from <HH:mm> /to <HH:mm>` |
| List Tasks   | `list`                                                           |
| Mark Task    | `mark <index>`                                                   |
| Unmark Task  | `unmark <index>`                                                 |
| Snooze       | `snooze <index> /to <YYYY-MM-DD>`                                |
| Delete       | `delete <index>`                                                 |
| Find         | `find <keyword>`                                                 |
| Due On       | `due on <YYYY-MM-DD>`                                            |
| Exit         | `bye`                                                            |

---
