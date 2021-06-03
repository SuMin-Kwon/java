package exam26;

public class ReportTool extends Tool {
	public void export() { // line n2    --- public이 빠졌었슴
		System.out.println("Rtool::export");
	}

	public static void main(String[] args) {
		Tool aTool = new ReportTool();
		Tool bTool = new Tool();
		callExport(aTool);
		callExport(bTool);
	}

	public static void callExport(Exportable ex) {
		ex.export();
	}
}
