package model.entity;

public class Scientist extends User{
    private String rankScientist;
    private String permission;

    public Scientist(int id, String name, String passWord, String type, String phoneNumber, String email) {
        super(id, name, passWord, type, phoneNumber, email);
    }

    public Scientist(String name, String passWord, String type, String phoneNumber, String email) {
        super(name, passWord, type, phoneNumber, email);
    }

    public Scientist(int id, String name, String passWord, String type, String phoneNumber, String email, String rankScientist, String permission) {
        super(id, name, passWord, type, phoneNumber, email);
        this.rankScientist = rankScientist;
        this.permission = permission;
    }

    public Scientist(String name, String passWord, String type, String phoneNumber, String email, String rankScientist, String permission) {
        super(name, passWord, type, phoneNumber, email);
        this.rankScientist = rankScientist;
        this.permission = permission;
    }

    public Scientist(String name, String passWord, String phoneNumber, String email, String rankScientist, String permission) {
        super(name, passWord, phoneNumber, email);
        this.rankScientist = rankScientist;
        this.permission = permission;
        this.setType("SCIENTIST");
    }

    public String getRankScientist() {
        return rankScientist;
    }

    public void setRankScientist(String rankScientist) {
        this.rankScientist = rankScientist;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return String.format("""
                Nhà khoa học: %s
                SĐT: %s
                Email: %s
                Cấp bậc: %s
                Quyền hạn: %s
                """, getName(), getPhoneNumber(), getEmail(), getRankScientist(), getPermission());
    }
}
