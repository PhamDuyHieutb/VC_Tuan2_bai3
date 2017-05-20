package hieu;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.common.cache.LoadingCache;

@Path("/{n}")
public class Bai3 {

	private LoadingCache<Integer, String> cache = CacheTest.getLoadingCache();
	private static long oldtime = System.currentTimeMillis();

	@GET
	@Produces("text/plain")
	public String getNumber(@PathParam("n") Integer number) throws ExecutionException {

		String y = "";
		long nowtime = System.currentTimeMillis();
		
		if (nowtime - oldtime > 10000) {
			cache.invalidateAll();
		}
		oldtime = getTime(nowtime);
		String s = "Cache :  " + Long.toString(cache.size()) + "\n";

		return y + s + cache.get(number);
	}
	
	public long getTime(long x) {
		long y = x;
		return y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
