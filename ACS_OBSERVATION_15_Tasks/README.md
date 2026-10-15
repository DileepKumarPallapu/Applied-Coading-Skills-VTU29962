# Applied Programming Skills — 15 Tasks

Each Java source file is named with its task number and task name.

1. Traffic Signal Congestion Analyzer — Sliding Window
2. Warehouse Product Frequency Manager — HashMap / Frequency Counting
3. Circular Delivery Route Repair — Linked List / Cycle Removal / K-Group Reversal
4. Server Request Validator — Stack / Bracket Validation
5. Factory Temperature Monitor — Monotonic Stack / Next Greater Element
6. Intelligent CPU Task Scheduler — Priority Queue / Cooldown Queue
7. Employee Hierarchy Analyzer — Binary Tree / Height and Levels
8. Emergency Route Meeting Point — Lowest Common Ancestor
9. Multi-City Delivery Optimization System — Min Heap / K-Way Merge / Top K
10. Campus Network Connectivity Checker — BFS / Connected Components
11. Forest Fire Spread Simulator — Multi-Source BFS
12. Smart Course Planner and Dependency Analyzer — Topological Sorting
13. Museum Treasure Route Planner — Dynamic Programming
14. Event Hall Reservation Manager — Greedy Interval Scheduling
15. Expedition Resource Optimization System — 0/1 Knapsack

## Compile and run

Open a terminal in this folder and run, for example:

```bash
javac 01_Traffic_Signal_Congestion_Analyzer.java
java TrafficSignalCongestionAnalyzer
```

Use the matching Java class name after `java`. All programs read input from standard input.

## Notes
- Task 3 expects: `N K`, then N list values, then cycle position (0-based; `-1` means no cycle).
- Task 7 and Task 8 build a binary tree from level-order values; `-1` represents a missing child.
- Task 9 expects M and K, then for each list: its size followed by its sorted values.
- Task 10 uses vertices numbered 1 through N.
- Task 12 uses directed prerequisite edges `u v` meaning `u` comes before `v`.
- Task 15 follows the mathematically valid 0/1 knapsack result; for the sample in the supplied material, capacity 10 gives maximum value 45 with items 1, 2, and 3.
