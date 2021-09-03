Problem Statement :
• Develop a solution for sharing expenses
• User can create an expense with another User and share the expense based on:
Percentage share
• Exact amount of share
• User should be able to view pending balances with other users
• User should be able to record a payment settlement to clear balances with a user.

Sample Input
addExpense
1 100 percentage 6 2 20.0 1 50.5 3 29.5
printBalance
1
printBalance
2
printBalance
3
settle
2 1
settle
1 3
printBalance
1
printBalance
2
printBalance
3