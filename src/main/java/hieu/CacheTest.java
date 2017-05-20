package hieu;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public final class CacheTest {
	private static LoadingCache<Integer, String> cache;
	static {
		cache = CacheBuilder.newBuilder().maximumSize(100) // set size
				.expireAfterAccess(10, TimeUnit.SECONDS) // set time expire
				.build(new CacheLoader<Integer, String>() {
					@Override
					public String load(Integer num) throws Exception {
						return nguyenTo(num);
					}
				});
	}

	public static LoadingCache<Integer, String> getLoadingCache() {
		return cache;
	}

	public static String nguyenTo(Integer num) {
		Integer[] arr = new Integer[num + 5];

		for (int i = 0; i < num + 5; ++i) {
			arr[i] = 1;
		}
		arr[0] = 0;

		for (int i = 2; i < num; ++i) {
			if (arr[i] == 1) {
				for (int j = 2; j < num; ++j) {
					if (i * j > num)
						break;
					arr[i * j] = 0;
				}
			}
		}

		String result = "";
		for (int i = 2; i <= num; ++i) {
			if (arr[i] == 1)
				result += "<>"+ i + "</>\n ";
		}

		return result;
	}
}