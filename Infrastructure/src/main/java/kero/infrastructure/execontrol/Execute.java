package kero.infrastructure.execontrol;

public class Execute {

	public static void execute() {
		ProcessBuilder pb = new ProcessBuilder("java", "-version");
		try {
			Process process = pb.start();


			//InputStreamのスレッド開始
			InputStreamThread it = new InputStreamThread(process.getInputStream());
			InputStreamThread et = new InputStreamThread(process.getErrorStream());
			it.start();
			et.start();

			//プロセスの終了待ち
			process.waitFor();

			//InputStreamのスレッド終了待ち
			it.join();
			et.join();

			System.out.println("戻り値：" + process.exitValue());

			//標準出力の内容を出力
			for (String s : it.getStringList()) {
				System.out.println(s);
			}
			//標準エラーの内容を出力
			for (String s : et.getStringList()) {
				System.err.println(s);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
