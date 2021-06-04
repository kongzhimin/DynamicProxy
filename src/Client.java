public class Client {
    public static void main(String[] args) {
 //       IShowPic ISP = new CRemoPic();
  //      CLocalPicShow CPic = new CLocalPicShow(ISP);
  //      IShowPic LocalPic = (IShowPic) CPic.getProxyInstance();
  //      LocalPic.ShowPic("AAA");

        ITestInterface IPic = new CTest();
        ITestInterface proxy =(ITestInterface) new CLocalPicShow(IPic).getProxyInstance();
        proxy.SendMessage("AAA");
    }

}
