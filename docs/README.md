# David User Guide


// Product screenshot goes here

David is a chatbot and task manager designed to help users stay organized effortlessly. Using David, users can add, find, track, and manage different types of tasks, such as to-dos, deadlines, and events with ease. It features a simple command-line interface and supports automatic task saving, ensuring that users never lose track of what needs to be done.

----------------------------------------------------------------------------------------------------

## Adding a Todo:  `todo`
Adds a todo task to the task list. <br>
Description: tasks without any date/time attached to it <br>
Format: todo `DESCRIPTION`<br>
Example: `todo CS2113` <br>
Expected output: 
----------------------------------------------------------------------------------------------------

```Got it. I've added this task:
[T][ ] CS2113
Now you have 6 tasks in the list.
Tasks saved to ./data/tasks.txt
```
----------------------------------------------------------------------------------------------------

## Adding a Deadline: `deadline`
Adds a deadline task to the task list. <br>
Description: tasks that need to be done before a specific date/time <br>
Format: deadline `DESCRIPTION` /by `SPECIFIC_DATE` `SPECIFIC_TIME` <br>
`SPECIFIC_DATE` should be in the format of year/month/day and `SPECIFIC_TIME` should be in `Hour:Minutes`  <br>
Example: `deadline hw /by 2020/03/04 3` <br>
Expected output: 
----------------------------------------------------------------------------------------------------

``` Got it. I've added this task:
[D][ ] hw (by: 2020/03/04 3)
Now you have 8 tasks in the list.
____________________________________________________________
Tasks saved to ./data/tasks.txt 
---------------------------------------------------------------------------------------------------- 
```
----------------------------------------------------------------------------------------------------


## Adding an Event: event
Adds an event to the task list. <br>
Description:  tasks that start at a specific date/time and ends at a specific date/time <br>
Format: event `DESCRIPTION` /from `START` /to `END` <br>
`START` and `END` should follow the format of `Year/Month/Day` and/or `Hour:Minutes` <br>
Example: `event project meeting /from Mon 2pm /to 4pm` <br>
Expected output: 
----------------------------------------------------------------------------------------------------
Got it. I've added this task:
[E][ ] project meeting (from: Mon 2pm to: 4pm)
Now you have 9 tasks in the list.
____________________________________________________________
Tasks saved to ./data/tasks.txt

----------------------------------------------------------------------------------------------------


## Listing all tasks: list <br>
Shows a list of all tasks in the task list. <br>
Format: list <br>
Example: list <br>
Expected output: <br>

----------------------------------------------------------------------------------------------------
```
____________________________________________________________
Here are the tasks in your list:

1.[D][ ] hw (by: 2020/03/04 3)
____________________________________________________________
2.[E][ ] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
3.[T][ ] CS2113
____________________________________________________________
```
----------------------------------------------------------------------------------------------------


## Marking Task as Done: mark
Marks a task as done in the task list.  <br>
Format: mark `INDEX_NUMBER`  <br>
Example: `mark 1`  <br>
Expected output of mark 1: 
```
-----------------------------------------------------------------------------____________________________________________________________
Nice! I've marked this task as done:
[X] project meeting
____________________________________________________________
----------------------------------------------------------------------------------------------------
```

## Marking Task as Not Done: unmark
Marks a task as not done in the task list.  <br>
Format: unmark `INDEX_NUMBER`  <br>
Example: `unmark 1`  <br>
Expected output of unmark 1:  <br>
```
----------------------------------------------------------------------------------------------------
____________________________________________________________
Okay! I've marked this task as not done:_______________________________
[ ] hw
____________________________________________________________
Tasks saved to ./data/tasks.txt

```
----------------------------------------------------------------------------------------------------


## Deleting a task: delete
Delete a specified task from the task list.  <br>
Format: delete `INDEX_NUMBER`
Example: `delete 1`  <br>
Expected output of delete 1:  <br>
```
----------------------------------------------------------------------------------------------------
There you go. I've removed this task for you:
[T][ ] revise CS2113 OOP
Now you have 2 tasks in the list.
----------------------------------------------------------------------------------------------------
```

## Finding tasks by keyword: find
Finds tasks which descriptions contain the given keyword. If task not found then, print out not found.  <br>
Format: find `KEYWORD`  <br>
Example: `find hw`  <br>
Expected output:  <br>
```
----------------------------------------------------------------------------------------------------
1.[D][ ] hw (by: 2020/03/04 3)
____________________________________________________________
These tasks were found
____________________________________________________________
```
----------------------------------------------------------------------------------------------------
Example: find CS1231
Expected output:
```
____________________________________________________________
Could not be found
____________________________________________________________

```
## Leaving the program: bye
Leaves the program. <br>
Format: bye  <br>
Example: `bye`  <br>
Expected output:
```
____________________________________________________________
Bye. Hope to see you again soon!
____________________________________________________________
```

## Saving the Data
Data is saved automatically after any command that results in the data being changed. <br>
If the program is closed unexpectedly or improperly, any unsaved changes will be lost, and the last saved version of the task list will be used when the program is restarted.

## Editing the Data
All tasks are stored in a file named tasks.txt, located in the current directory. <br>
Users can manually edit this file if needed, but modifications outside the program may lead to unexpected behavior.


