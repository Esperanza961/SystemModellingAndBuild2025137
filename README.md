Department Store Employee Management System
📌 Overview
This project is a console-based Employee Management System designed for a fictional department store company. It demonstrates core computing concepts such as file handling, sorting algorithms, searching techniques, and hierarchical data structures.
The system loads employee records from a CSV file and provides menu-driven options to:
- Sort employees by last name using manual merge sort
- Search employees by last name or department using binary search
- Display the organizational hierarchy using a binary tree
This project was developed as part of an academic module to showcase algorithmic thinking, modular design, and practical application of data structures.

🏢 Company Context
We chose a department store as the company setting because:
- It naturally involves large employee datasets across multiple departments (Sales, HR, Logistics, Customer Service, etc.).
- It requires efficient management tools to quickly locate employees and visualize organizational structure.
- It provides a realistic scenario where sorting, searching, and hierarchical representation are essential for daily operations.

⚙️ Features
- CSV Utility
- Reads employee records from a CSV file
- Displays records in a clean, formatted table
- Supports saving and appending records
- Sort Menu (Merge Sort)
- Implements recursive merge sort manually (no built-in sort functions)
- Sorts employees by last name
- Displays the first N sorted records
- Search Menu (Binary Search)
- Sorts records first (via merge sort)
- Performs binary search on last name or department
- Case-insensitive search with prefix matching (e.g., searching "Mar" finds "Martinez")
- Tree Menu (Binary Tree)
- Builds a binary tree hierarchy of employees by job title
- Inserts nodes level by level (Head Manager → Senior Manager → Manager → Assistant Manager → Team Lead → Developers → Specialists → Clerks/Support)
- Displays the hierarchy using level-order traversal

🔍 Why These Techniques?
We deliberately chose classic algorithms and data structures instead of shortcuts to demonstrate understanding:
- Merge Sort
- Stable, efficient (O(n log n))
- Handles large datasets better than simple algorithms like bubble sort
- Recursive design shows mastery of divide-and-conquer
- Binary Search
- Much faster than linear search (O(log n) vs O(n))
- Perfect for sorted employee lists
- Demonstrates efficient lookup in HR systems
- Binary Tree
- Natural fit for representing organizational hierarchies
- Level-order insertion ensures balanced distribution of employees
- Traversals (in-order, pre-order, post-order, level-order) illustrate different ways to explore hierarchical data
These choices highlight algorithmic efficiency, clarity, and scalability — critical for managing a department store’s workforce.

🧩 Modular Design
Each menu option is implemented as a separate class that implements the MenuAction interface:
- SortData → Sorting logic
- SearchData → Searching logic
- TreeMenu → Hierarchy visualization
- CsvUtility → File handling and display
This modular approach keeps the codebase clean, reusable, and easy to extend.

🚀 How to Run
- Clone the repository
- Compile the project (javac *.java)
- Run the main dispatcher class (java MainDispatcher)
- Follow the menu prompts to sort, search, or view the hierarchy

📚 Learning Outcomes
- Manual implementation of merge sort and binary search
- Practical use of binary trees for hierarchical data
- Modular design with reusable utility classes
- Real-world application in a department store HR context
