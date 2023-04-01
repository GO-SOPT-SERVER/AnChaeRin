public class ConvenienceStore {
    // 편의점 브랜드
    String brand;
    // 편의점 주소
    String address;
    // 직원 수
    int staffCount;
    // 방문자 수
    int visitorCount;

    public ConvenienceStore(String brand, String address, int staffCount, int visitorCount) {
        this.brand = brand;
        this.address = address;
        this.staffCount = staffCount;
        this.visitorCount = visitorCount;
    }

    public void addStaffCount() {
        staffCount++;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void addVisitorCount() {
        visitorCount++;
    }

    public void initVisitorCount() {
        visitorCount = 0;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void printConvenienceStoreInfo() {
        System.out.println("편의점 브랜드: " + brand);
        System.out.println("편의점 주소: " + address);
        System.out.println("편의점 직원 수: " + staffCount);
        System.out.println("편의점 방문자 수: " + visitorCount);
    }

    public static void main(String[] args) {
        ConvenienceStore firstGS = new ConvenienceStore("GS 25", "지구 어딘가", 8, 0);

        firstGS.addStaffCount();
        firstGS.addVisitorCount();

        firstGS.printConvenienceStoreInfo();
    }
}