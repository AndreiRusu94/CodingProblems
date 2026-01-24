package third;
/*
You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

Example 1:


Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.

*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem690 {
    public static void main(String[] args) {
        Solution690 solution = new Solution690();
        Solution690.Employee emp1 = solution.new Employee();
        emp1.id = 1;
        emp1.importance = 5;
        emp1.subordinates = List.of(2, 3);
        Solution690.Employee emp2 = solution.new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = List.of();
        Solution690.Employee emp3 = solution.new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        emp3.subordinates = List.of();
        List<Solution690.Employee> employees = List.of(emp1, emp2, emp3);
        System.out.println(solution.getImportance(employees, 1));
        System.out.println(solution.getImportanceDFS(employees, 1));
    }
}

class Solution690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> importance = new HashMap<>();
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee e : employees) {
            empMap.put(e.id, e);
        }

        generateImportance(empMap, importance, id);

        return importance.get(id);
    }

    private int generateImportance(Map<Integer, Employee> employees, Map<Integer, Integer> importance, Integer id) {
        Employee e = employees.get(id);
        importance.put(id, e.importance);
        if (e.subordinates == null) {
            return importance.get(id);
        }

        for (Integer subordinateId : e.subordinates) {
            importance.put(id, importance.getOrDefault(id, e.importance) + generateImportance(employees, importance, subordinateId));
        }

        return importance.get(id);
    }

    public int getImportanceDFS(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee e : employees) {
            empMap.put(e.id, e);
        }

        return getImportanceDFS(empMap, id);
    }

    public int getImportanceDFS(Map<Integer, Employee> empMap, int id) {
        Employee root = empMap.get(id);

        int total = root.importance;
        for (int subId : root.subordinates) {
            total += getImportanceDFS(empMap, subId);
        }

        return total;
    }

}

