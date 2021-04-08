package com.df.addperson;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import Models.Person;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView firstName;
    private TextView lastName;
    private TextView salary;
    private TextView age;
    private TextView position;
    private TextView email;
    private Button btnAdd;
    private Button btnFilterAge;
    private Button btnFilterSalary;
    private Button btnFilterPosition;
    private ListView response;
    private ArrayList<Person> personList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        salary = findViewById(R.id.txtSalary);
        age = findViewById(R.id.txtAge);
        position = findViewById(R.id.txtPosition);
        email = findViewById(R.id.txtEmail);
        response = findViewById(R.id.lvResponse);
        btnAdd = findViewById(R.id.btnAdd);
        btnFilterAge = findViewById(R.id.btnFilterAge);
        btnFilterSalary = findViewById(R.id.btnFilterSalary);
        btnFilterPosition = findViewById(R.id.btnFilterPosition);

        btnAdd.setOnClickListener(this);
        btnFilterAge.setOnClickListener(this);
        btnFilterSalary.setOnClickListener(this);
        btnFilterPosition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd){
            addPerson();
            cleanFields();
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personList);
            response.setAdapter(adapter);
        } else if (v.getId() == R.id.btnFilterAge){
            ascendingOrderOfAge();
            ArrayList<String> personAge = new ArrayList<>();
            String olderAge = "the oldest person is: \n" + personList.get(personList.size() - 1);
            String youngerAge = "The youngest person is: \n" + personList.get(0);
            personAge.add(youngerAge);
            personAge.add(olderAge);
            getAdapter(personAge);
        } else if (v.getId() == R.id.btnFilterSalary) {
            ascendingOrderOfSalary();
            ArrayList<String> salaryPerson = new ArrayList<>();
            String lowSalary = "The person with the lowest salary is: " + "\n" + personList.get(0);
            String highSalary = "The person with the highest salary is: " + "\n" + personList.get(personList.size() - 1);
            String averageSalary = "The average person's salary is: " + "\n" + "$" + averageSalary();
            salaryPerson.add(lowSalary);
            salaryPerson.add(highSalary);
            salaryPerson.add(averageSalary);
            getAdapter(salaryPerson);
        } else if (v.getId() == R.id.btnFilterPosition){
            ArrayList<String> positionList = new ArrayList<>();
            String position1 = "technologist";
            String position2 = "engineer";
            String technologist = "";
            String engineer = "";

            for (Person positionPerson : personList) {
                if (positionPerson.getPosition().equals(position1)) {
                    technologist = "The total number of  " +position1 +" is: "+ countPerson(position1)+"\n"+
                            "The average salary is: $ " + averageSalaryPosition(position1);
                } else if (positionPerson.getPosition().equals(position2)) {
                    engineer = "The total number of "+ position2 + " is: " +countPerson(position2)+"\n"+
                            "The average salary is: $ " + averageSalaryPosition(position2);
                }
            }
            positionList.add(technologist);
            positionList.add(engineer);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, positionList);
            response.setAdapter(adapter);
        }
    }

    private void getAdapter(ArrayList<String> list){
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        response.setAdapter(adapter);
    }

    private void addPerson(){
        String _firstName = firstName.getText().toString();
        String _lastName = lastName.getText().toString();
        double _salary = Double.parseDouble(salary.getText().toString());
        int _age = Integer.parseInt(age.getText().toString());
        String _email = email.getText().toString();
        String _position = position.getText().toString().toLowerCase();

        Person person = new Person(_firstName, _lastName, _salary, _age, _email, _position);
        personList.add(person);
    }
    private void cleanFields(){
        firstName.setText("");
        lastName.setText("");
        salary.setText("");
        age.setText("");
        email.setText("");
        position.setText("");
    }

    private void ascendingOrderOfAge() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return  new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        });
    }

    private void ascendingOrderOfSalary() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new Double(o1.getSalary()).compareTo(new Double(o2.getSalary()));
            }
        });
    }

    private Integer countPerson(String posit) {
        int count = 0;

        for (Person person : personList) {
            if (person.getPosition().equals(posit)) {
                count++;
            }
        }
        return count;
    }

    private Double averageSalary() {
        int count = 0;
        double totalSalary = 0;
        double average = 0;
        for (Person salary : personList) {
            totalSalary += salary.getSalary();
            count++;
        }
        average = totalSalary / count;
        return average;
    }
    private Double averageSalaryPosition(String posit) {
        int count = 0;
        double subtotalSalary = 0;
        double average = 0;

        for (Person person : personList) {
            if (person.getPosition().equals(posit)) {
                subtotalSalary += person.getSalary();
                count++;
            }
        }
        average = subtotalSalary / count;
        return average;
    }

}
