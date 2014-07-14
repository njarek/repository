package pl.store.intergation;

import java.io.File;

import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Before;

public class NewTradeTest {

	private Tomcat mTomcat;
	/** The temporary directory in which Tomcat and the app are deployed. */
	private String mWorkingDir = System.getProperty("java.io.tmpdir");

	
	@Before
	public void setup() throws Throwable {
	 /* mTomcat = new Tomcat();
	  mTomcat.setPort(0);
	  mTomcat.setBaseDir(mWorkingDir);
	  mTomcat.getHost().setAppBase(mWorkingDir);
	  mTomcat.getHost().setAutoDeploy(true);
	  mTomcat.getHost().setDeployOnStartup(true);
	  
	  String contextPath = "/" + getApplicationId();
	  File webApp = new File(mWorkingDir, getApplicationId());
	  File oldWebApp = new File(webApp.getAbsolutePath());
	  FileUtils.deleteDirectory(oldWebApp);
	  new ZipExporterImpl(createWebArchive()).exportTo(new File(mWorkingDir + "/" + getApplicationId() + ".war"),
	          true);
	  mTomcat.addWebapp(mTomcat.getHost(), contextPath, webApp.getAbsolutePath());  
	  
	  
	  
	  
	  mTomcat.start();
*/
	}
	
	
	
	


	private String getApplicationId() {
		return "store";
	}



	@After
	public final void teardown() throws Throwable {
	  if (mTomcat.getServer() != null
	            && mTomcat.getServer().getState() != LifecycleState.DESTROYED) {
	        if (mTomcat.getServer().getState() != LifecycleState.STOPPED) {
	              mTomcat.stop();
	        }
	        mTomcat.destroy();
	    }
	}

	protected int getTomcatPort() {
		  return mTomcat.getConnector().getLocalPort();
		}

}
