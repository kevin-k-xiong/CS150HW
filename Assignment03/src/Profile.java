public class Profile {

    private String name;
    private String major;
    private int age;

    /**
     * Creates a profile with default age and major.
     *
     * @param name profile name
     */
    public Profile(String name) {
        this(name, 18, "Business");
    }

    /**
     * Creates a profile with default major.
     *
     * @param name profile name
     * @param age  profile age
     */
    public Profile(String name, int age) {
        this(name, age, "Business");
    }

    /**
     * Creates a profile with all fields.
     *
     * @param name  profile name
     * @param age   profile age
     * @param major profile major
     */
    public Profile(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    /**
     * Returns the profile name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the profile major.
     *
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Returns the profile age.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }
}
