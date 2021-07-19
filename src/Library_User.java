class Library_User {
    String fName, lName;
    int cardId;

    public void getUserInfo (String fName, String lName, int cardId) {
        this.fName = fName;
        this.lName = lName;
        this.cardId = cardId;
    }


    public void setUserInfo(){
        System.out.println("Library User's Full Name: " + lName + ", " + fName);
        System.out.println("Library Card: " + cardId);
    }

}
