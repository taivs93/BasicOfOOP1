package entity;

public enum Selection {
    ADD(1,"Thêm sinh viên"),
    UPDATE(2,"Sửa thông tin sinh viên"),
    DELETE(3,"Xóa sinh viên"),
    GETBYID(4,"Tìm kiếm theo mã số"),
    GETBYNAME(5,"Tìm kiếm theo tên"),
    SORTBYNAME(6,"Sắp xếp theo tên"),
    SORTBYGPA(7,"Sắp xếp theo điểm trung bình"),
    PRINT(8,"In ra danh sách sinh viên"),
    EXIT(9,"Thoát");

    private int choice;
    private String description;

    Selection(int choice, String description){
        this.choice = choice;
        this.description = description;
    }

    public int getChoice() {
        return choice;
    }

    public String getDescription() {
        return description;
    }

    public static Selection getSelectionFromValue(int choice){
        for(Selection selection : Selection.values()){
            if(selection.getChoice() == choice) return selection;
        }
        throw new IllegalArgumentException("Lựa chọn không hợp lệ");
    }
}
