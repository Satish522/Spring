package com.hibernate.manytomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="subject")
@SequenceGenerator(
name = "subject_seq", 
sequenceName = "subject_seq" ,
initialValue = 1, allocationSize = 1)
public class Subject {
	 	@Id
	 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="subject_seq")
	    @Column(name = "subject_id")
	    private int id;
	 
	    @Column(name = "subject_name")
	    private String name;
	     
	    
	    @ManyToMany(mappedBy="subjects")
	    private List<Student> students = new ArrayList<Student>();

	    public Subject() {}
	    
		public Subject(String name) {
			// TODO Auto-generated constructor stub
			this.name=name;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}

 
		public void setName(String name) {
			this.name = name;
		}


		public List<Student> getStudents() {
			return students;
		}


		public void setStudents(List<Student> students) {
			this.students = students;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((students == null) ? 0 : students.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Subject other = (Subject) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (students == null) {
				if (other.students != null)
					return false;
			} else if (!students.equals(other.students))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Subject [id=" + id + ", name=" + name + ", students=" + students + "]";
		}
	    
	    
	    
}
