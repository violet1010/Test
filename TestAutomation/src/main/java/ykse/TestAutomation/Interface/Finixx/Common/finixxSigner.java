package ykse.TestAutomation.Interface.Finixx.Common;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Contract;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import ykse.TestAutomation.Common.HttpSampler;

/**
 * @author MiNG
 * @version 1.0
 * @since 1.0 (2016-04-25 16:51)
 */
public final class finixxSigner {

	private static final Set<String> EXCLUDED_KEYS = Sets.newHashSet("Signature", "SignatureType");
	//private static final String SignKey = "81F5BFBFE0AD49E8B7E1";
	private static final String SignKey = "6CDE2EA48BDC44C19E77";

	public static String serialize(JSONObject data) {
		ObjectMapper mapper = new ObjectMapper();
		// JSON ----> JsonNode
		String rootStr = data.toString();
		JsonNode root = null;
		try {
			root = mapper.readTree(rootStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serialize(root);

	}

	public static String serialize(JsonNode root) {

		// JSON ----> JsonNode
		if (root == null) {
			return StringUtils.EMPTY;
		}

		switch (root.getNodeType()) {

		case ARRAY:
			return serialize(((ArrayNode) root));

		case OBJECT:
			return serialize(((ObjectNode) root));

		case NUMBER:
			return new BigDecimal(root.asText()).setScale(6, RoundingMode.HALF_UP).toString();

		default:
			return root.asText();
		}
	}

	private static String serialize(ObjectNode objectNode) {

		 final String value = StreamSupport
		 .stream(Spliterators.spliteratorUnknownSize(objectNode.fields(),
		 Spliterator.ORDERED), false)
		 .filter(x -> !EXCLUDED_KEYS.contains(x.getKey()))
		 .filter(x->isNotEmpty(x.getValue()))
		 .sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
		 .map(x -> String.join("=", x.getKey().toLowerCase(),
		 serialize(x.getValue()))).collect(Collectors.joining("&"));
		
		 return value;
	}

	private static boolean isNotEmpty(final JsonNode jsonNode) {

		if (jsonNode.isMissingNode() || jsonNode.isNull()) {
			return false;
		}

		if (jsonNode.isArray() || jsonNode.isObject()) {
			return jsonNode.size() > 0;
		}

		final String literalValue = jsonNode.asText();
		return StringUtils.isNotEmpty(literalValue);
	}

	private static String serialize(ArrayNode arrayNode) {

		final String value = StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(arrayNode.elements(), Spliterator.ORDERED), false)
				.map(finixxSigner::serialize).collect(Collectors.joining("|"));

		return value;
	}

	public static void main(String[] args) {
		// String jsonMessage
		// ="{\"locationcd\":\"147\",\"password\":\"9C4876E4C86A6248472BA13A3584E9C8\",\"code\":\"1077\",\"serialNumber\":\"635980407559340000\",\"UserId\":\"ADMIN\",\"OprnDate\":\"2016-05-05\",\"ShiftNo\":\"1\",\"tokenNum\":\"79841be8cf544bdd9c231cac2f194a11\",\"userName\":\"BO\",\"UUid\":\"f2505cf4e95e4e659ba6151cce25dbde\",\"version\":\"1.0.11.23\",\"RefundBo\":{\"ChannelCd\":\"BO\",\"BookingId\":\"1470160504005545\",\"Tickets\":[{\"TicketNo\":\"1471605040018213\"}]}}";
		String jsonMessage = "{\"code\":\"0104\",\"version\":\"1.0.0.0\",\"serialNumber\":\"635984136562337745\",\"userName\":\"WEB\",\"password\":\"6E370235A6240B0150D3449967DDF2CA\",\"locationcd\":\"57\",\"tokenNum\":\"CE10A64FB2A0AFB299F6154F4B7066EC\",\"ticketBooking\":{\"transation\":\"BUY_TICKET\",\"bookingBills\":[{\"bookingId\":\"5701605070045771\",\"tempBookingId\":\"pl99178\",\"booking\":{\"serviceFee\":0,\"throughFlg\":false,\"throughSeqList\":null,\"throughId\":null,\"acxMemberId\":null,\"consumeId\":null,\"discountCardId\":null,\"totalCashPaid\":100,\"totalCashChange\":0,\"cardSupplyCashFlg\":null,\"thirdId\":null,\"YtBatchNo\":null,\"ytTraceNo\":null,\"markingCardId\":null},\"tickets\":[{\"ticketNo\":null,\"bookingId\":null,\"seqNo\":\"1\",\"sectionId\":\"0000000000000001\",\"rowId\":\"1\",\"colId\":\"5\",\"priceType\":\"成人票\",\"priceAmt\":0,\"printFlg\":true,\"bookingFeeAmt\":0,\"bookingFeeApplInd\":\"T\",\"serviceFee\":0,\"vipTypeCd\":\"\",\"memberFlg\":false,\"percent\":null,\"payments\":[{\"seqNo\":\"1\",\"paymentType\":\"Cash\",\"totalAmtPaid\":0,\"baseAmt\":0,\"approvalCode\":null,\"remarks\":null,\"chequeNo\":null,\"chequeRemarks\":null,\"creditCardNo\":null,\"arrearge_BillNo\":null,\"salesCd\":null,\"cashVoucherTypeDesc\":null,\"cashVoucherType\":null,\"cashVoucherNo\":null,\"akcMemberId\":null,\"akcPromoId\":null,\"marking\":0,\"akcExchangecd\":null,\"voucherPolicySeq\":null,\"voucherBarcode\":null,\"voucherTypeDesc\":null,\"voucherTypeCd\":null,\"memberCard_FacadeCd\":null,\"memberCard_GradeId\":null,\"throughFlg\":false,\"refundFlg\":false,\"voucherTempRefKey\":null,\"cardWalletSeqId\":null,\"thirdId\":null,\"yongtaiConsumeId\":null,\"yongtaiBatchNumber\":null,\"unionConfirmCode\":null,\"unionReferanceCode\":null,\"paymentTransationId\":null,\"yongtaiTrack\":null,\"allowanceCd\":null}],\"orderNum\":null,\"originalPrice\":null,\"resAlowancePrice\":null,\"resAllowanceCd\":null}],\"bookingFeePayment\":[{\"seqNo\":\"1\",\"paymentType\":\"Cash\",\"totalAmtPaid\":0,\"baseAmt\":0,\"approvalCode\":null,\"remarks\":null,\"chequeNo\":null,\"chequeRemarks\":null,\"creditCardNo\":null,\"arrearge_BillNo\":null,\"salesCd\":null,\"cashVoucherTypeDesc\":null,\"cashVoucherType\":null,\"cashVoucherNo\":null,\"akcMemberId\":null,\"akcPromoId\":null,\"marking\":0,\"akcExchangecd\":null,\"voucherPolicySeq\":null,\"voucherBarcode\":null,\"voucherTypeDesc\":null,\"voucherTypeCd\":null,\"memberCard_FacadeCd\":null,\"memberCard_GradeId\":null,\"throughFlg\":false,\"refundFlg\":false,\"voucherTempRefKey\":null,\"cardWalletSeqId\":null,\"thirdId\":null,\"yongtaiConsumeId\":null,\"yongtaiBatchNumber\":null,\"unionConfirmCode\":null,\"unionReferanceCode\":null,\"paymentTransationId\":null,\"yongtaiTrack\":null,\"allowanceCd\":null}],\"deduction_Times\":\"0\",\"ticketTypeRemarkInfo\":null}],\"userId\":\"WEBBOOKING\",\"workStationId\":\"WEB\",\"oprnDate\":\"2016-05-09\",\"shiftNo\":\"0\",\"patron\":{\"patronId\":null,\"creditCardNo\":null,\"name\":\"WEB\",\"telephoneNo\":null,\"confirmId\":\"2014091778860157\",\"bookflg\":\"Y\",\"midCardNo\":null,\"memberCardNo\":null,\"remark\":\"\",\"createUserId\":null,\"createDate\":null,\"verifyCode\":null,\"thirdId\":null},\"channelCd\":\"WEB\",\"writeShiftFlg\":false,\"printTicketFlg\":false,\"increaseFlg\":true,\"leastPriceFlg\":false,\"saleSpeed\":0,\"locationcd\":\"57\"},\"posBooking\":null,\"channelCd\":null,\"yTBonus\":null,\"ePay\":null,\"mobilePhone\":null}";

		JSONObject myJsonObject = new JSONObject(jsonMessage);
		Iterator<?> it = myJsonObject.keys();
		ArrayList<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			String key = (String) it.next();
			list.add(key.toLowerCase());
		}
		list.sort(null);
		System.out.println(list.toString());
		String res = sign(myJsonObject);
		// CommonRequestData.signRequestData(data).toString()

		String responseStr = HttpSampler.sendPost("http://172.33.0.83:29955" + "/api/basic/bookingOrder",
				CommonRequestData.signRequestData(myJsonObject).toString());
		System.out.println(res);
	}

	public enum SignType {
		MD5, SHA1,
		/* Enum end */;
	}

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };

	private static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

	private static final byte[] CONNECTOR = encode("&", DEFAULT_CHARSET);

	@Contract("null, _ -> fail")
	private static void ensureNotNull(Object source, String name) {
		if (source == null) {
			throw new IllegalArgumentException(name + " can not be null.");
		}
	}

	@Contract("null, _ -> fail")
	private static void ensureNotEmpty(byte[] source, String name) {
		if (ArrayUtils.isEmpty(source)) {
			throw new IllegalArgumentException(name + " can not be empty.");
		}
	}

	private static byte[] encode(String source, Charset charset) {

		ensureNotNull(source, "source");
		ensureNotNull(charset, "charset");

		final ByteBuffer sourceBuffer = DEFAULT_CHARSET.encode(source);
		final byte[] sourceData = new byte[sourceBuffer.remaining()];
		sourceBuffer.get(sourceData);

		return sourceData;
	}

	private static String toHexString(byte[] source) {

		final StringBuilder stringBuffer = new StringBuilder(source.length * 2);

		for (final byte buf : source) {
			stringBuffer.append(HEX_DIGITS[(buf >>> 4) & 0x0F]).append(HEX_DIGITS[buf & 0x0F]);
		}

		return stringBuffer.toString();
	}

	/**
	 * @param source
	 *            待签名源字串
	 * @param signType
	 *            签名类型
	 * @param signKey
	 *            签名密钥，只能为ASCII可见字符
	 * @return 十六进制全大写的签名结果
	 */
	public static String sign(JsonNode data, SignType signType, String signKey) {

		String source = serialize(data);

		ensureNotNull(signType, "signType");
		ensureNotNull(signKey, "signKey");

		final byte[] sourceData = encode(Strings.nullToEmpty(source), DEFAULT_CHARSET);
		final byte[] signKeyData = encode(signKey, DEFAULT_CHARSET);

		return sign(sourceData, signType, signKeyData);
	}

	public static String sign(JSONObject data, SignType signType, String signKey) {

		String source = serialize(data);

		ensureNotNull(signType, "signType");
		ensureNotNull(signKey, "signKey");

		final byte[] sourceData = encode(Strings.nullToEmpty(source), DEFAULT_CHARSET);
		final byte[] signKeyData = encode(signKey, DEFAULT_CHARSET);

		return sign(sourceData, signType, signKeyData);
	}

	public static String sign(JSONObject data) {

		String source = serialize(data);
		SignType signType = SignType.MD5;
		final byte[] sourceData = encode(Strings.nullToEmpty(source), DEFAULT_CHARSET);
		final byte[] signKeyData = encode(SignKey, DEFAULT_CHARSET);
		return sign(sourceData, signType, signKeyData);
	}

	/**
	 * @param source
	 *            待签名源字串
	 * @param signType
	 *            签名类型
	 * @param signKeyData
	 *            签名密钥字节数据
	 * @return 十六进制全小写的签名结果
	 */
	public static String sign(String source, SignType signType, byte[] signKeyData) {

		ensureNotNull(signType, "signType");
		ensureNotEmpty(signKeyData, "signKeyData");

		final byte[] sourceData = encode(Strings.nullToEmpty(source), DEFAULT_CHARSET);

		return sign(sourceData, signType, signKeyData);
	}

	/**
	 * @param sourceData
	 *            待签名字节数据
	 * @param signType
	 *            签名类型
	 * @param signKeyData
	 *            签名密钥字节数据
	 * @return 十六进制全小写的签名结果
	 */
	public static String sign(byte[] sourceData, SignType signType, byte[] signKeyData) {

		ensureNotNull(sourceData, "sourceData");
		ensureNotNull(signType, "signType");
		ensureNotEmpty(signKeyData, "signKeyData");

		final byte[] signData = signData(sourceData, signType, signKeyData);

		return toHexString(signData);
	}

	/**
	 * @param sourceData
	 *            待签名字节数据
	 * @param signType
	 *            签名类型
	 * @param signKeyData
	 *            签名密钥字节数据
	 * @return 签名结果字节数据
	 */
	public static byte[] signData(byte[] sourceData, SignType signType, byte[] signKeyData) {

		ensureNotNull(sourceData, "sourceData");
		ensureNotNull(signType, "signType");
		ensureNotEmpty(signKeyData, "signKeyData");

		final MessageDigest messageDigester;
		try {
			messageDigester = MessageDigest.getInstance(signType.name());
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}

		messageDigester.update(encode("key=", DEFAULT_CHARSET));
		messageDigester.update(signKeyData);
		messageDigester.update(CONNECTOR);
		messageDigester.update(sourceData);
		final byte[] digest = messageDigester.digest();

		return digest;
	}
}
