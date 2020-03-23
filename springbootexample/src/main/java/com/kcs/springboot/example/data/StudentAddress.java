package com.kcs.springboot.example.data;

/**
 * @author Andrius Baltrunas
 */
public class StudentAddress
{
	private int id;
	private int studentId;
	private String country;
	private String city;
	private String street;
	private String postCode;

	public StudentAddress(int studentId, String country, String city, String street, String postCode)
	{
		this.studentId = studentId;
		this.country = country;
		this.city = city;
		this.street = street;
		this.postCode = postCode;
	}

	public StudentAddress(int id, int studentId, String country, String city, String street, String postCode)
	{
		this(studentId, country, city, street, postCode);
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getStudentId()
	{
		return studentId;
	}

	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getPostCode()
	{
		return postCode;
	}

	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
}
