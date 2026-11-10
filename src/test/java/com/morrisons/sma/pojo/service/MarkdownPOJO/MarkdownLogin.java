package com.morrisons.sma.pojo.service.MarkdownPOJO;

public class MarkdownLogin {
	
	private String userName;

    private String provider;

    private String password;

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getProvider ()
    {
        return provider;
    }

    public void setProvider (String provider)
    {
        this.provider = provider;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [userName = "+userName+", provider = "+provider+", password = "+password+"]";
    }

}
