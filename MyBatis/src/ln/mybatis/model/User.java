package ln.mybatis.model;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.room_id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    private Integer roomId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.room_id
     *
     * @return the value of user.room_id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.room_id
     *
     * @param roomId the value for user.room_id
     *
     * @mbggenerated Wed Jun 25 10:52:34 CST 2014
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}