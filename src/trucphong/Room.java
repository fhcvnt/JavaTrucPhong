package trucphong;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Room extends Thread {

	protected Shell shell;
	private String ngaybatdau;
	private String tenImage;
	public CLabel lbImage;
	private int soImage;

	public static void main(String[] args) {
		try {
			Room window = new Room();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.MIN);
		// shlDanhSchTrc = new Shell();
		shell.setImage(SWTResourceManager.getImage(Room.class, "/trucphong/Icon/Xucxac/Poison.png"));
		// shlDanhSchTrc.setSize(944, 468);
		shell.setSize(920, 460);
		shell.setText("Danh sách trực phòng");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);

		CLabel lbDanhsachtrucphong = new CLabel(composite, SWT.CENTER);
		lbDanhsachtrucphong.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbDanhsachtrucphong.setFont(SWTResourceManager.getFont("Times New Roman", 40, SWT.BOLD));
		lbDanhsachtrucphong.setBounds(85, 10, 534, 74);
		lbDanhsachtrucphong.setText("Danh sách trực phòng");

		CLabel lbHoten = new CLabel(composite, SWT.NONE);
		lbHoten.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lbHoten.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.BOLD));
		lbHoten.setBounds(27, 90, 230, 40);
		lbHoten.setText("Họ && Tên");

		CLabel lbSothe = new CLabel(composite, SWT.CENTER);
		lbSothe.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lbSothe.setText("Số Thẻ");
		lbSothe.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.BOLD));
		lbSothe.setBounds(263, 90, 107, 40);

		CLabel lbTenthu2 = new CLabel(composite, SWT.NONE);
		lbTenthu2.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu2.setBounds(27, 138, 230, 40);

		CLabel lbTenthu3 = new CLabel(composite, SWT.NONE);
		lbTenthu3.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu3.setBounds(27, 184, 230, 40);

		CLabel lbTenthu4 = new CLabel(composite, SWT.NONE);
		lbTenthu4.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu4.setBounds(27, 230, 230, 40);

		CLabel lbTenthu5 = new CLabel(composite, SWT.NONE);
		lbTenthu5.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu5.setBounds(27, 276, 230, 40);

		CLabel lbTenthu6 = new CLabel(composite, SWT.NONE);
		lbTenthu6.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu6.setBounds(27, 322, 230, 40);

		CLabel lbTenthu7 = new CLabel(composite, SWT.NONE);
		lbTenthu7.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbTenthu7.setBounds(27, 368, 230, 40);

		CLabel lbNgaytruc = new CLabel(composite, SWT.NONE);
		lbNgaytruc.setAlignment(SWT.CENTER);
		lbNgaytruc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lbNgaytruc.setText("Ngày Trực");
		lbNgaytruc.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.BOLD));
		lbNgaytruc.setBounds(502, 90, 150, 40);

		CLabel lbSothethu4 = new CLabel(composite, SWT.NONE);
		lbSothethu4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu4.setAlignment(SWT.CENTER);
		lbSothethu4.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu4.setBounds(263, 230, 107, 40);

		CLabel lbSothethu3 = new CLabel(composite, SWT.NONE);
		lbSothethu3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu3.setAlignment(SWT.CENTER);
		lbSothethu3.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu3.setBounds(263, 184, 107, 40);

		CLabel lbSothethu2 = new CLabel(composite, SWT.NONE);
		lbSothethu2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu2.setAlignment(SWT.CENTER);
		lbSothethu2.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu2.setBounds(263, 136, 107, 40);

		CLabel lbSothethu5 = new CLabel(composite, SWT.NONE);
		lbSothethu5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu5.setAlignment(SWT.CENTER);
		lbSothethu5.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu5.setBounds(263, 276, 107, 40);

		CLabel lbSothethu6 = new CLabel(composite, SWT.NONE);
		lbSothethu6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu6.setAlignment(SWT.CENTER);
		lbSothethu6.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu6.setBounds(263, 322, 107, 40);

		CLabel lbSothethu7 = new CLabel(composite, SWT.NONE);
		lbSothethu7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbSothethu7.setAlignment(SWT.CENTER);
		lbSothethu7.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbSothethu7.setBounds(263, 368, 107, 40);

		CLabel lbNgayThu2 = new CLabel(composite, SWT.NONE);
		lbNgayThu2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu2.setAlignment(SWT.CENTER);
		lbNgayThu2.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu2.setBounds(502, 138, 150, 40);

		CLabel lbThu = new CLabel(composite, SWT.CENTER);
		lbThu.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lbThu.setText("Thứ");
		lbThu.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.BOLD));
		lbThu.setBounds(376, 90, 120, 40);

		CLabel lbThuhai = new CLabel(composite, SWT.NONE);
		lbThuhai.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThuhai.setText("Thứ hai");
		lbThuhai.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThuhai.setBounds(376, 136, 120, 40);

		CLabel lbThuba = new CLabel(composite, SWT.NONE);
		lbThuba.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThuba.setText("Thứ ba");
		lbThuba.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThuba.setBounds(376, 184, 120, 40);

		CLabel lbThutu = new CLabel(composite, SWT.NONE);
		lbThutu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThutu.setText("Thứ tư");
		lbThutu.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThutu.setBounds(376, 230, 120, 40);

		CLabel lbThunam = new CLabel(composite, SWT.NONE);
		lbThunam.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThunam.setText("Thứ năm");
		lbThunam.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThunam.setBounds(376, 276, 120, 40);

		CLabel lbThusau = new CLabel(composite, SWT.NONE);
		lbThusau.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThusau.setText("Thứ sáu");
		lbThusau.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThusau.setBounds(376, 322, 120, 40);

		CLabel lbThubay = new CLabel(composite, SWT.NONE);
		lbThubay.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lbThubay.setText("Thứ bảy");
		lbThubay.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbThubay.setBounds(376, 368, 120, 40);

		CLabel lbNgayThu3 = new CLabel(composite, SWT.NONE);
		lbNgayThu3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu3.setAlignment(SWT.CENTER);
		lbNgayThu3.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu3.setBounds(502, 184, 150, 40);

		CLabel lbNgayThu4 = new CLabel(composite, SWT.NONE);
		lbNgayThu4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu4.setAlignment(SWT.CENTER);
		lbNgayThu4.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu4.setBounds(502, 230, 150, 40);

		CLabel lbNgayThu5 = new CLabel(composite, SWT.NONE);
		lbNgayThu5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu5.setAlignment(SWT.CENTER);
		lbNgayThu5.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu5.setBounds(502, 276, 150, 40);

		CLabel lbNgayThu6 = new CLabel(composite, SWT.NONE);
		lbNgayThu6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu6.setAlignment(SWT.CENTER);
		lbNgayThu6.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu6.setBounds(502, 322, 150, 40);

		CLabel lbNgayThu7 = new CLabel(composite, SWT.NONE);
		lbNgayThu7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbNgayThu7.setAlignment(SWT.CENTER);
		lbNgayThu7.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lbNgayThu7.setBounds(502, 368, 150, 40);

		lbImage = new CLabel(composite, SWT.NONE);
		lbImage.setFont(SWTResourceManager.getFont("Times New Roman", 16, SWT.NORMAL));
		lbImage.setBackground(SWTResourceManager.getImage(Room.class, "/trucphong/Icon/Xucxac/Ban tay.png"));
		lbImage.setAlignment(SWT.CENTER);
		lbImage.setBounds(674, 158, 230, 230);

		Button btnStart = new Button(composite, SWT.NONE);
		btnStart.setText("Start");
		btnStart.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnStart.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.BOLD));
		btnStart.setBounds(736, 103, 91, 40);

		DateTime dateNgaybatdau = new DateTime(composite, SWT.BORDER);
		dateNgaybatdau.setFont(SWTResourceManager.getFont("Times New Roman", 18, SWT.NORMAL));
		dateNgaybatdau.setBounds(736, 36, 150, 35);
		// dateNgaybatdau.setDate(java.time.LocalDate.now().getYear(),
		// java.time.LocalDate.now().getMonthValue()+1,
		// java.time.LocalDate.now().getDayOfMonth());

		// Làm rỗng các ngày
		// ------------------------------------------------------------------------------------------
		lbNgayThu2.setText("");
		lbNgayThu3.setText("");
		lbNgayThu4.setText("");
		lbNgayThu5.setText("");
		lbNgayThu6.setText("");
		lbNgayThu7.setText("");
		lbTenthu2.setVisible(false);
		lbTenthu3.setVisible(false);
		lbTenthu4.setVisible(false);
		lbTenthu5.setVisible(false);
		lbTenthu6.setVisible(false);
		lbTenthu7.setVisible(false);
		lbSothethu2.setText("");
		lbSothethu3.setText("");
		lbSothethu4.setText("");
		lbSothethu5.setText("");
		lbSothethu6.setText("");
		lbSothethu7.setText("");

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Sắp xếp các ngày đầu tiên, nếu là thứ 2
		String ngay, thang, nam;
		int songay, sothang, sonam;
		ngay = "0" + dateNgaybatdau.getDay();
		ngay = ngay.substring(ngay.length() - 2);
		thang = "0" + (dateNgaybatdau.getMonth() + 1);
		thang = thang.substring(thang.length() - 2);
		nam = dateNgaybatdau.getYear() + "";

		// ngaybatdau=dateNgaybatdau.getDay()+"/"+(dateNgaybatdau.getMonth()+1)+"/"+dateNgaybatdau.getYear();
		ngaybatdau = ngay + "/" + thang + "/" + nam;
		// Lấy thứ trong tuần, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday,
		// Sunday
		String thu = java.time.YearMonth.of(dateNgaybatdau.getYear(), dateNgaybatdau.getMonth() + 1)
				.atDay(dateNgaybatdau.getDay()).getDayOfWeek().name();

		if (thu.equals("MONDAY")) {
			lbNgayThu2.setText(ngaybatdau);

			songay = dateNgaybatdau.getDay();
			sothang = dateNgaybatdau.getMonth() + 1;
			sonam = dateNgaybatdau.getYear();
			int[] ngaytn = congNgay(songay, sothang, sonam);
			songay = ngaytn[0];
			sothang = ngaytn[1];
			sonam = ngaytn[2];
			ngay = "0" + songay;
			ngay = ngay.substring(ngay.length() - 2);
			thang = "0" + sothang;
			thang = thang.substring(thang.length() - 2);
			nam = sonam + "";
			lbNgayThu3.setText(ngay + "/" + thang + "/" + nam);

			ngaytn = congNgay(songay, sothang, sonam);
			songay = ngaytn[0];
			sothang = ngaytn[1];
			sonam = ngaytn[2];
			ngay = "0" + songay;
			ngay = ngay.substring(ngay.length() - 2);
			thang = "0" + sothang;
			thang = thang.substring(thang.length() - 2);
			nam = sonam + "";
			lbNgayThu4.setText(ngay + "/" + thang + "/" + nam);

			ngaytn = congNgay(songay, sothang, sonam);
			songay = ngaytn[0];
			sothang = ngaytn[1];
			sonam = ngaytn[2];
			ngay = "0" + songay;
			ngay = ngay.substring(ngay.length() - 2);
			thang = "0" + sothang;
			thang = thang.substring(thang.length() - 2);
			nam = sonam + "";
			lbNgayThu5.setText(ngay + "/" + thang + "/" + nam);

			ngaytn = congNgay(songay, sothang, sonam);
			songay = ngaytn[0];
			sothang = ngaytn[1];
			sonam = ngaytn[2];
			ngay = "0" + songay;
			ngay = ngay.substring(ngay.length() - 2);
			thang = "0" + sothang;
			thang = thang.substring(thang.length() - 2);
			nam = sonam + "";
			lbNgayThu6.setText(ngay + "/" + thang + "/" + nam);

			ngaytn = congNgay(songay, sothang, sonam);
			songay = ngaytn[0];
			sothang = ngaytn[1];
			sonam = ngaytn[2];
			ngay = "0" + songay;
			ngay = ngay.substring(ngay.length() - 2);
			thang = "0" + sothang;
			thang = thang.substring(thang.length() - 2);
			nam = sonam + "";
			lbNgayThu7.setText(ngay + "/" + thang + "/" + nam);
		} else {
			lbNgayThu2.setText("");
			lbNgayThu3.setText("");
			lbNgayThu4.setText("");
			lbNgayThu5.setText("");
			lbNgayThu6.setText("");
			lbNgayThu7.setText("");
		}

		// Sự kiện Start
		// ******************************************************************************************
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!lbNgayThu2.getText().isEmpty()) {
					dateNgaybatdau.setVisible(false);
					btnStart.setVisible(false);

					// hien thi noi dung
					// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					lbTenthu2.setVisible(true);
					lbTenthu3.setVisible(true);
					lbTenthu4.setVisible(true);
					lbTenthu5.setVisible(true);
					lbTenthu6.setVisible(true);
					lbTenthu7.setVisible(true);

					int solanlap = randSpace(10, 18);
					int dem = 0;

					try {
						while (dem < solanlap) {
							soImage = randSpace(1, 18);
							tenImage = "/trucphong/Icon/Xucxac/Xuc xac " + soImage + ".png";
							lbImage.setBackground(SWTResourceManager.getImage(Room.class, tenImage));

							int[] so2to7 = rand2to7();
							// ***********************
							switch (so2to7[0]) {
							case 2:
								lbTenthu2.setText("Đinh Văn Tiền");
								lbSothethu2.setText("20802");
								break;
							case 3:
								lbTenthu2.setText("Đỗ Đăng Khoa");
								lbSothethu2.setText("25985");
								break;
							case 4:
								lbTenthu2.setText("Tô Ngọc Trí");
								lbSothethu2.setText("21608");
								break;
							case 5:
								lbTenthu2.setText("Đặng Minh Hiếu");
								lbSothethu2.setText("14562");
								break;
							case 6:
								lbTenthu2.setText("Nguyễn Thanh Bình");
								lbSothethu2.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[1]) {
							case 2:
								lbTenthu3.setText("Đinh Văn Tiền");
								lbSothethu3.setText("20802");
								break;
							case 3:
								lbTenthu3.setText("Đỗ Đăng Khoa");
								lbSothethu3.setText("25985");
								break;
							case 4:
								lbTenthu3.setText("Tô Ngọc Trí");
								lbSothethu3.setText("21608");
								break;
							case 5:
								lbTenthu3.setText("Đặng Minh Hiếu");
								lbSothethu3.setText("14562");
								break;
							case 6:
								lbTenthu3.setText("Nguyễn Thanh Bình");
								lbSothethu3.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[2]) {
							case 2:
								lbTenthu4.setText("Đinh Văn Tiền");
								lbSothethu4.setText("20802");
								break;
							case 3:
								lbTenthu4.setText("Đỗ Đăng Khoa");
								lbSothethu4.setText("25985");
								break;
							case 4:
								lbTenthu4.setText("Tô Ngọc Trí");
								lbSothethu4.setText("21608");
								break;
							case 5:
								lbTenthu4.setText("Đặng Minh Hiếu");
								lbSothethu4.setText("14562");
								break;
							case 6:
								lbTenthu4.setText("Nguyễn Thanh Bình");
								lbSothethu4.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[3]) {
							case 2:
								lbTenthu5.setText("Đinh Văn Tiền");
								lbSothethu5.setText("20802");
								break;
							case 3:
								lbTenthu5.setText("Đỗ Đăng Khoa");
								lbSothethu5.setText("25985");
								break;
							case 4:
								lbTenthu5.setText("Tô Ngọc Trí");
								lbSothethu5.setText("21608");
								break;
							case 5:
								lbTenthu5.setText("Đặng Minh Hiếu");
								lbSothethu5.setText("14562");
								break;
							case 6:
								lbTenthu5.setText("Nguyễn Thanh Bình");
								lbSothethu5.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[4]) {
							case 2:
								lbTenthu6.setText("Đinh Văn Tiền");
								lbSothethu6.setText("20802");
								break;
							case 3:
								lbTenthu6.setText("Đỗ Đăng Khoa");
								lbSothethu6.setText("25985");
								break;
							case 4:
								lbTenthu6.setText("Tô Ngọc Trí");
								lbSothethu6.setText("21608");
								break;
							case 5:
								lbTenthu6.setText("Đặng Minh Hiếu");
								lbSothethu6.setText("14562");
								break;
							case 6:
								lbTenthu6.setText("Nguyễn Thanh Bình");
								lbSothethu6.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[5]) {
							case 2:
								lbTenthu7.setText("Đinh Văn Tiền");
								lbSothethu7.setText("20802");
								break;
							case 3:
								lbTenthu7.setText("Đỗ Đăng Khoa");
								lbSothethu7.setText("25985");
								break;
							case 4:
								lbTenthu7.setText("Tô Ngọc Trí");
								lbSothethu7.setText("21608");
								break;
							case 5:
								lbTenthu7.setText("Đặng Minh Hiếu");
								lbSothethu7.setText("14562");
								break;
							case 6:
								lbTenthu7.setText("Nguyễn Thanh Bình");
								lbSothethu7.setText("17430");
								break;
							}

							lbTenthu2.update();
							lbTenthu3.update();
							lbTenthu4.update();
							lbTenthu5.update();
							lbTenthu6.update();
							lbTenthu7.update();

							lbSothethu2.update();
							lbSothethu3.update();
							lbSothethu4.update();
							lbSothethu5.update();
							lbSothethu6.update();
							lbSothethu7.update();
							lbImage.update();
							Thread.sleep(200);
							dem++;
						}

						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// Hien thi 3 2 1
						for (int i = 3; i > 0; i--) {
							tenImage = "/trucphong/Icon/image321/so" + i + ".png";
							lbImage.setBackground(SWTResourceManager.getImage(Room.class, tenImage));

							int[] so2to7 = rand2to7();
							// ***********************
							switch (so2to7[0]) {
							case 2:
								lbTenthu2.setText("Đinh Văn Tiền");
								lbSothethu2.setText("20802");
								break;
							case 3:
								lbTenthu2.setText("Đỗ Đăng Khoa");
								lbSothethu2.setText("25985");
								break;
							case 4:
								lbTenthu2.setText("Tô Ngọc Trí");
								lbSothethu2.setText("21608");
								break;
							case 5:
								lbTenthu2.setText("Đặng Minh Hiếu");
								lbSothethu2.setText("14562");
								break;
							case 6:
								lbTenthu2.setText("Nguyễn Thanh Bình");
								lbSothethu2.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[1]) {
							case 2:
								lbTenthu3.setText("Đinh Văn Tiền");
								lbSothethu3.setText("20802");
								break;
							case 3:
								lbTenthu3.setText("Đỗ Đăng Khoa");
								lbSothethu3.setText("25985");
								break;
							case 4:
								lbTenthu3.setText("Tô Ngọc Trí");
								lbSothethu3.setText("21608");
								break;
							case 5:
								lbTenthu3.setText("Đặng Minh Hiếu");
								lbSothethu3.setText("14562");
								break;
							case 6:
								lbTenthu3.setText("Nguyễn Thanh Bình");
								lbSothethu3.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[2]) {
							case 2:
								lbTenthu4.setText("Đinh Văn Tiền");
								lbSothethu4.setText("20802");
								break;
							case 3:
								lbTenthu4.setText("Đỗ Đăng Khoa");
								lbSothethu4.setText("25985");
								break;
							case 4:
								lbTenthu4.setText("Tô Ngọc Trí");
								lbSothethu4.setText("21608");
								break;
							case 5:
								lbTenthu4.setText("Đặng Minh Hiếu");
								lbSothethu4.setText("14562");
								break;
							case 6:
								lbTenthu4.setText("Nguyễn Thanh Bình");
								lbSothethu4.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[3]) {
							case 2:
								lbTenthu5.setText("Đinh Văn Tiền");
								lbSothethu5.setText("20802");
								break;
							case 3:
								lbTenthu5.setText("Đỗ Đăng Khoa");
								lbSothethu5.setText("25985");
								break;
							case 4:
								lbTenthu5.setText("Tô Ngọc Trí");
								lbSothethu5.setText("21608");
								break;
							case 5:
								lbTenthu5.setText("Đặng Minh Hiếu");
								lbSothethu5.setText("14562");
								break;
							case 6:
								lbTenthu5.setText("Nguyễn Thanh Bình");
								lbSothethu5.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[4]) {
							case 2:
								lbTenthu6.setText("Đinh Văn Tiền");
								lbSothethu6.setText("20802");
								break;
							case 3:
								lbTenthu6.setText("Đỗ Đăng Khoa");
								lbSothethu6.setText("25985");
								break;
							case 4:
								lbTenthu6.setText("Tô Ngọc Trí");
								lbSothethu6.setText("21608");
								break;
							case 5:
								lbTenthu6.setText("Đặng Minh Hiếu");
								lbSothethu6.setText("14562");
								break;
							case 6:
								lbTenthu6.setText("Nguyễn Thanh Bình");
								lbSothethu6.setText("17430");
								break;
							}

							// ***********************
							switch (so2to7[5]) {
							case 2:
								lbTenthu7.setText("Đinh Văn Tiền");
								lbSothethu7.setText("20802");
								break;
							case 3:
								lbTenthu7.setText("Đỗ Đăng Khoa");
								lbSothethu7.setText("25985");
								break;
							case 4:
								lbTenthu7.setText("Tô Ngọc Trí");
								lbSothethu7.setText("21608");
								break;
							case 5:
								lbTenthu7.setText("Đặng Minh Hiếu");
								lbSothethu7.setText("14562");
								break;
							case 6:
								lbTenthu7.setText("Nguyễn Thanh Bình");
								lbSothethu7.setText("17430");
								break;
							}

							lbTenthu2.update();
							lbTenthu3.update();
							lbTenthu4.update();
							lbTenthu5.update();
							lbTenthu6.update();
							lbTenthu7.update();

							lbSothethu2.update();
							lbSothethu3.update();
							lbSothethu4.update();
							lbSothethu5.update();
							lbSothethu6.update();
							lbSothethu7.update();
							lbImage.update();
							Thread.sleep(700);
						}

						Thread.sleep(400);

						tenImage = "/trucphong/Icon/Xucxac/Poison.png";
						lbImage.setBackground(SWTResourceManager.getImage(Room.class, tenImage));
						lbImage.update();

					} catch (InterruptedException e1) {

					}

					int[] so2to7 = rand2to7();
					// ***********************
					switch (so2to7[0]) {
					case 2:
						lbTenthu2.setText("Đinh Văn Tiền");
						lbSothethu2.setText("20802");
						break;
					case 3:
						lbTenthu2.setText("Đỗ Đăng Khoa");
						lbSothethu2.setText("25985");
						break;
					case 4:
						lbTenthu2.setText("Tô Ngọc Trí");
						lbSothethu2.setText("21608");
						break;
					case 5:
						lbTenthu2.setText("Đặng Minh Hiếu");
						lbSothethu2.setText("14562");
						break;
					case 6:
						lbTenthu2.setText("Nguyễn Thanh Bình");
						lbSothethu2.setText("17430");
						break;
					}

					// ***********************
					switch (so2to7[1]) {
					case 2:
						lbTenthu3.setText("Đinh Văn Tiền");
						lbSothethu3.setText("20802");
						break;
					case 3:
						lbTenthu3.setText("Đỗ Đăng Khoa");
						lbSothethu3.setText("25985");
						break;
					case 4:
						lbTenthu3.setText("Tô Ngọc Trí");
						lbSothethu3.setText("21608");
						break;
					case 5:
						lbTenthu3.setText("Đặng Minh Hiếu");
						lbSothethu3.setText("14562");
						break;
					case 6:
						lbTenthu3.setText("Nguyễn Thanh Bình");
						lbSothethu3.setText("17430");
						break;
					}

					// ***********************
					switch (so2to7[2]) {
					case 2:
						lbTenthu4.setText("Đinh Văn Tiền");
						lbSothethu4.setText("20802");
						break;
					case 3:
						lbTenthu4.setText("Đỗ Đăng Khoa");
						lbSothethu4.setText("25985");
						break;
					case 4:
						lbTenthu4.setText("Tô Ngọc Trí");
						lbSothethu4.setText("21608");
						break;
					case 5:
						lbTenthu4.setText("Đặng Minh Hiếu");
						lbSothethu4.setText("14562");
						break;
					case 6:
						lbTenthu4.setText("Nguyễn Thanh Bình");
						lbSothethu4.setText("17430");
						break;
					}

					// ***********************
					switch (so2to7[3]) {
					case 2:
						lbTenthu5.setText("Đinh Văn Tiền");
						lbSothethu5.setText("20802");
						break;
					case 3:
						lbTenthu5.setText("Đỗ Đăng Khoa");
						lbSothethu5.setText("25985");
						break;
					case 4:
						lbTenthu5.setText("Tô Ngọc Trí");
						lbSothethu5.setText("21608");
						break;
					case 5:
						lbTenthu5.setText("Đặng Minh Hiếu");
						lbSothethu5.setText("14562");
						break;
					case 6:
						lbTenthu5.setText("Nguyễn Thanh Bình");
						lbSothethu5.setText("17430");
						break;
					}

					// ***********************
					switch (so2to7[4]) {
					case 2:
						lbTenthu6.setText("Đinh Văn Tiền");
						lbSothethu6.setText("20802");
						break;
					case 3:
						lbTenthu6.setText("Đỗ Đăng Khoa");
						lbSothethu6.setText("25985");
						break;
					case 4:
						lbTenthu6.setText("Tô Ngọc Trí");
						lbSothethu6.setText("21608");
						break;
					case 5:
						lbTenthu6.setText("Đặng Minh Hiếu");
						lbSothethu6.setText("14562");
						break;
					case 6:
						lbTenthu6.setText("Nguyễn Thanh Bình");
						lbSothethu6.setText("17430");
						break;
					}

					// ***********************
					switch (so2to7[5]) {
					case 2:
						lbTenthu7.setText("Đinh Văn Tiền");
						lbSothethu7.setText("20802");
						break;
					case 3:
						lbTenthu7.setText("Đỗ Đăng Khoa");
						lbSothethu7.setText("25985");
						break;
					case 4:
						lbTenthu7.setText("Tô Ngọc Trí");
						lbSothethu7.setText("21608");
						break;
					case 5:
						lbTenthu7.setText("Đặng Minh Hiếu");
						lbSothethu7.setText("14562");
						break;
					case 6:
						lbTenthu7.setText("Nguyễn Thanh Bình");
						lbSothethu7.setText("17430");
						break;
					}
					lbTenthu2.update();
					lbTenthu3.update();
					lbTenthu4.update();
					lbTenthu5.update();
					lbTenthu6.update();
					lbTenthu7.update();

					lbSothethu2.update();
					lbSothethu3.update();
					lbSothethu4.update();
					lbSothethu5.update();
					lbSothethu6.update();
					lbSothethu7.update();
				}
			}
		});

		// Sắp xếp ngày trực
		// ***********************************************************************************************
		dateNgaybatdau.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String ngay, thang, nam;
				int songay, sothang, sonam;
				ngay = "0" + dateNgaybatdau.getDay();
				ngay = ngay.substring(ngay.length() - 2);
				thang = "0" + (dateNgaybatdau.getMonth() + 1);
				thang = thang.substring(thang.length() - 2);
				nam = dateNgaybatdau.getYear() + "";

				// ngaybatdau=dateNgaybatdau.getDay()+"/"+(dateNgaybatdau.getMonth()+1)+"/"+dateNgaybatdau.getYear();
				ngaybatdau = ngay + "/" + thang + "/" + nam;
				// Lấy thứ trong tuần, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday,
				// Sunday
				String thu = java.time.YearMonth.of(dateNgaybatdau.getYear(), dateNgaybatdau.getMonth() + 1)
						.atDay(dateNgaybatdau.getDay()).getDayOfWeek().name();

				if (thu.equals("MONDAY")) {
					lbNgayThu2.setText(ngaybatdau);

					songay = dateNgaybatdau.getDay();
					sothang = dateNgaybatdau.getMonth() + 1;
					sonam = dateNgaybatdau.getYear();
					int[] ngaytn = congNgay(songay, sothang, sonam);
					songay = ngaytn[0];
					sothang = ngaytn[1];
					sonam = ngaytn[2];
					ngay = "0" + songay;
					ngay = ngay.substring(ngay.length() - 2);
					thang = "0" + sothang;
					thang = thang.substring(thang.length() - 2);
					nam = sonam + "";
					lbNgayThu3.setText(ngay + "/" + thang + "/" + nam);

					ngaytn = congNgay(songay, sothang, sonam);
					songay = ngaytn[0];
					sothang = ngaytn[1];
					sonam = ngaytn[2];
					ngay = "0" + songay;
					ngay = ngay.substring(ngay.length() - 2);
					thang = "0" + sothang;
					thang = thang.substring(thang.length() - 2);
					nam = sonam + "";
					lbNgayThu4.setText(ngay + "/" + thang + "/" + nam);

					ngaytn = congNgay(songay, sothang, sonam);
					songay = ngaytn[0];
					sothang = ngaytn[1];
					sonam = ngaytn[2];
					ngay = "0" + songay;
					ngay = ngay.substring(ngay.length() - 2);
					thang = "0" + sothang;
					thang = thang.substring(thang.length() - 2);
					nam = sonam + "";
					lbNgayThu5.setText(ngay + "/" + thang + "/" + nam);

					ngaytn = congNgay(songay, sothang, sonam);
					songay = ngaytn[0];
					sothang = ngaytn[1];
					sonam = ngaytn[2];
					ngay = "0" + songay;
					ngay = ngay.substring(ngay.length() - 2);
					thang = "0" + sothang;
					thang = thang.substring(thang.length() - 2);
					nam = sonam + "";
					lbNgayThu6.setText(ngay + "/" + thang + "/" + nam);

					ngaytn = congNgay(songay, sothang, sonam);
					songay = ngaytn[0];
					sothang = ngaytn[1];
					sonam = ngaytn[2];
					ngay = "0" + songay;
					ngay = ngay.substring(ngay.length() - 2);
					thang = "0" + sothang;
					thang = thang.substring(thang.length() - 2);
					nam = sonam + "";
					lbNgayThu7.setText(ngay + "/" + thang + "/" + nam);
				} else {
					lbNgayThu2.setText("");
					lbNgayThu3.setText("");
					lbNgayThu4.setText("");
					lbNgayThu5.setText("");
					lbNgayThu6.setText("");
					lbNgayThu7.setText("");
				}
			}
		});
		dateNgaybatdau.setFocus();

		// phím tắt chụp màn hình - Ctrl + S
		// *************************************************************************************************************************************************
		Display.getDefault().addFilter(SWT.KeyUp, new Listener() {
			@Override
			public void handleEvent(Event e) {
				if ((e.stateMask & SWT.MODIFIER_MASK) == SWT.CTRL && e.keyCode == 's') {
					String[] FILTER_NAMES = { "JPG (*.jpg)", "PNG (*.png)" };
					// đuôi file có thể mở
					String[] FILTER_EXTS = { "*.jpg", "*.png" };

					FileDialog dlg = new FileDialog(shell, SWT.SAVE);
					dlg.setFilterNames(FILTER_NAMES);
					dlg.setFilterExtensions(FILTER_EXTS);
					dlg.setFileName("Lich truc phong");
					String imgFilePath = dlg.open(); // ten file luu
					if (imgFilePath != null) {
						try {
							// save the screenshot as a png
							GC gc = new GC(composite);
							Rectangle eclipseWindow = composite.getBounds();
							Image screenshot = new Image(Display.getDefault(), eclipseWindow);
							gc.copyArea(screenshot, eclipseWindow.x, eclipseWindow.y);
							gc.dispose();

							ImageLoader imgLoader = new ImageLoader();
							imgLoader.data = new ImageData[] { screenshot.getImageData() };
							imgLoader.save(imgFilePath, SWT.IMAGE_PNG);
						} catch (Exception exc) {

						}

					}
				}
			}
		});

		// Chụp màn hình khi double click vào Image
		lbImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				String[] FILTER_NAMES = { "JPG (*.jpg)", "PNG (*.png)" };
				// đuôi file có thể mở
				String[] FILTER_EXTS = { "*.jpg", "*.png" };

				FileDialog dlg = new FileDialog(shell, SWT.SAVE);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFileName("Lich truc phong");
				String imgFilePath = dlg.open(); // ten file luu
				if (imgFilePath != null) {
					try {
						// save the screenshot as a png
						GC gc = new GC(composite);
						Rectangle eclipseWindow = composite.getBounds();
						Image screenshot = new Image(Display.getDefault(), eclipseWindow);
						gc.copyArea(screenshot, eclipseWindow.x, eclipseWindow.y);
						gc.dispose();

						ImageLoader imgLoader = new ImageLoader();
						imgLoader.data = new ImageData[] { screenshot.getImageData() };
						imgLoader.save(imgFilePath, SWT.IMAGE_PNG);
					} catch (Exception exc) {

					}

				}
			}
		});

	}

	// Tính năm nhuận
	// --------------------------------------------------------------------------------------------------
	public boolean namNhuan(int year) {
		if (year % 4 == 0) {
			if (year % 1000 == 0) {
				return true;
			} else if (year % 100 == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	// Cộng 1 ngày vào 1 ngày bất kỳ
	// ---------------------------------------------------------------------------------------------------
	public int[] congNgay(int day, int month, int year) {
		int[] ngaythangnam = new int[3];
		if (namNhuan(year)) {
			if (month == 2) {
				if (day < 29) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 29) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
				if (day < 31) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 31) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day < 30) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 30) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 12) {
				if (day < 31) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 31) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = 1;
					ngaythangnam[2] = year + 1;
					return ngaythangnam;
				}
			}
		} else {
			if (month == 2) {
				if (day < 28) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 28) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
				if (day < 31) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 31) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day < 30) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 30) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = month + 1;
					ngaythangnam[2] = year;
					return ngaythangnam;
				}
			} else if (month == 12) {
				if (day < 31) {
					ngaythangnam[0] = day + 1;
					ngaythangnam[1] = month;
					ngaythangnam[2] = year;
					return ngaythangnam;
				} else if (day == 31) {
					ngaythangnam[0] = 1;
					ngaythangnam[1] = 1;
					ngaythangnam[2] = year + 1;
					return ngaythangnam;
				}
			}
		}

		return ngaythangnam;
	}

	// rand số trong khoảng từ a - b
	public int randSpace(int a, int b) {
		Random rand = new Random();
		int so = rand.nextInt(b - a + 1);
		// return (a + (int) (Math.random() * (b - a + 1)));
		return so + a;
	}

	// Hàm random từ 2 tới 6 ngẫu nhiên không theo thứ tự
	public int[] rand2to7() {
		int[] rand = new int[6];
		rand[0] = randSpace(2, 6);
		rand[1] = randSpace(2, 6);
		rand[2] = randSpace(2, 6);
		rand[3] = randSpace(2, 6);
		rand[4] = randSpace(2, 6);
		rand[5] = randSpace(2, 6);
		
		while(rand[0] == rand[1]) {
			rand[1] = randSpace(2, 6);
			rand[5] = randSpace(2, 6);
		}
		while(rand[0] == rand[2] || rand[1] == rand[2]) {
			rand[2] = randSpace(2, 6);
			rand[5] = randSpace(2, 6);
		}
		while(rand[0] == rand[3] || rand[1] == rand[3] || rand[2] == rand[3]) {
			rand[3] = randSpace(2, 6);
			rand[5] = randSpace(2, 6);
		}
		while(rand[0] == rand[4] || rand[1] == rand[4] || rand[2] == rand[4] || rand[3] == rand[4]) {
			rand[4] = randSpace(2, 6);
			rand[5] = randSpace(2, 6);
		}
		
//		boolean kiemtra;
//		kiemtra = rand[0] != rand[1] && rand[0] != rand[2] && rand[0] != rand[3] && rand[0] != rand[4]
//				&& rand[1] != rand[2] && rand[1] != rand[3] && rand[1] != rand[4] && rand[2] != rand[3]
//				&& rand[2] != rand[4] && rand[3] != rand[4];
//		while (!kiemtra) {
//			rand[0] = randSpace(2, 6);
//			rand[1] = randSpace(2, 6);
//			rand[2] = randSpace(2, 6);
//			rand[3] = randSpace(2, 6);
//			rand[4] = randSpace(2, 6);
//			//rand[5] = randSpace(2, 6);
//			kiemtra = rand[0] != rand[1] && rand[0] != rand[2] && rand[0] != rand[3] && rand[0] != rand[4]
//					&& rand[1] != rand[2] && rand[1] != rand[3] && rand[1] != rand[4] && rand[2] != rand[3]
//					&& rand[2] != rand[4] && rand[3] != rand[4];
//		}
		return rand;
	}

	// ***********************************************************************************************************
	// Resize hinh anh
	public Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}

	// khai bao Thread
	@Override
	public void run() {
		super.run();

	}
}
