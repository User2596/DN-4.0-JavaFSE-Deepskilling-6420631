package com.example.MockitoProject2;

public class MyService
{
	ExternalApi ea;
	
	public MyService(ExternalApi ea) {
		this.ea = ea;
	}
	
    public String fetchData() {
    	return ea.getData();
    }
}