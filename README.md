# Yuzu Chatbot - User Guide 🪽

**Yuzu** is a lightweight, text-based task management assistant designed to help you stay up with your daily schedule with ease!

---

## Quick Start
1. Ensure you have **Java 17** or higher installed on your computer.
2. Open your terminal or command prompt.
3. Run the chatbot using: `java -jar yuzu.jar`
4. Type your commands into the box and press **Enter**!

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
* **Event**: A task that occurs during a specific time period.
    * **Format**: `event DESCRIPTION /from START_DATE /to END_DATE`
    * **Example**: `event Career Fair /from 2026-02-25 /to 2026-02-26`

### 2. Managing Your Tasks
* **Listing Tasks**: See all your current tasks in one list.
    * **Command**: `list`
* **Marking as Done**: Check off a task when you've finished it.
    * **Command**: `mark INDEX` (e.g., `mark 1`)
* **Unmarking**: If you made a mistake, you can mark a task as not done.
    * **Command**: `unmark INDEX`
* **Deleting Tasks**: Permanently remove a task from your list.
    * **Command**: `delete INDEX`

### 3. Finding and Filtering
* **Search by Keyword**: Find tasks that contain a specific word in their description.
    * **Command**: `find KEYWORD`
* **Check Due Dates**: See which tasks are due on a specific date.
    * **Command**: `due on YYYY-MM-DD`

### 4. Postponing Tasks (Snooze) 🌟
Plans changed? Use the **Snooze** feature to reschedule your deadlines or events to a later date.
* **Format**: `snooze INDEX /to YYYY-MM-DD`
* **Example**: `snooze 2 /to 2026-03-12`

---

## Command Summary Table

| Action | Format |
| :--- | :--- |
| **Add Todo** | `todo <description>` |
| **Add Deadline** | `deadline <description> /by <YYYY-MM-DD>` |
| **Add Event** | `event <description> /from <date> /to <date>` |
| **Snooze** | `snooze <index> /to <YYYY-MM-DD>` |
| **Delete** | `delete <index>` |
| **Find** | `find <keyword>` |
| **Exit** | `bye` |

---
