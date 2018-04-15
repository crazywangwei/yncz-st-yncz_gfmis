package gov.gfmis.card.accountmanager.action;

import gov.gfmis.card.accountmanager.ibs.ICardAccountManagerBusiness;
import gov.gfmis.card.common.CardCommonFactory;
import gov.gfmis.fap.util.Global;
import gov.gfmis.pay.common.action.CommonAction;
import gov.gfmis.pay.common.util.PlatformTools;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * ���񿨿����й��ɻ�ɾ������
 * @author lgq
 *2016-10-08
 */
public class DeleteCardAccountAction extends CommonAction {

	/**
	 * ���а汾��ʶId
	 */
	private static final long serialVersionUID = -6525840942364488430L;
	/**
	 * ҵ����ӿ�
	 */
	private ICardAccountManagerBusiness business = CardCommonFactory.getCardAccountManagerService();

	
	/**
	 * ���캯��
	 */
	public DeleteCardAccountAction() {
		super();
	}
	
	public void realActionPerform(ActionEvent e) {
		List list = this.getPanel().getOperationTable()[0].getSelectedData();
		if(null == list || list.size() == 0) {
			PlatformTools.showSuccessDialog("��ѡ����Ҫɾ��������!");
			return;
		}
		Global.mainFrame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		try{
			business.deletePayee(list);
			PlatformTools.showSuccessDialog("ɾ���ɹ�!");
		}catch(Exception e2) {
			PlatformTools.showFailDialog("ɾ��ʧ�ܣ�"+e2.getMessage());
		}finally {
			Global.mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		this.getPanel().onJumpCurrentPage();
	}

}
