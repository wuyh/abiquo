package com.abiquo.server.core.enterprise;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abiquo.server.core.common.DefaultRepBase;

@Repository
public class ApprovalRep extends DefaultRepBase
{
    @Autowired
    private ApprovalDAO approvalDAO;

    @Autowired
    private ApprovalManagerDAO approvalManagerDAO;

    public ApprovalRep()
    {

    }

    public ApprovalRep(final EntityManager entityManager)
    {
        assert entityManager != null;
        assert entityManager.isOpen();

        this.entityManager = entityManager;

        approvalDAO = new ApprovalDAO(entityManager);
    }

    public Approval findApprovalById(final Integer approvalId)
    {
        return approvalDAO.findById(approvalId);
    }

    public Approval findApprovalByToken(final String token)
    {
        return approvalDAO.findByToken(token);
    }

    public List<Approval> findAll()
    {
        List<Approval> list = approvalDAO.findAll();
        return list;
    }

    public void insertApproval(final Approval approval)
    {
        approvalDAO.persist(approval);
        approvalDAO.flush();
    }

    public List<ApprovalManager> findAllApprovalManager()
    {
        List<ApprovalManager> appmList = approvalManagerDAO.findAll();
        return appmList;
    }

    public void insertApprovalManager(final ApprovalManager appm)
    {
        approvalManagerDAO.persist(appm);
        approvalManagerDAO.flush();

    }

    public ApprovalManager findApprovalManagerById(final Integer approvalManagerId)
    {
        assert approvalManagerId != null;
        return approvalManagerDAO.findById(approvalManagerId);
    }

    public void deleteApprovalManager(final ApprovalManager appm)
    {
        approvalManagerDAO.remove(appm);
        approvalManagerDAO.flush();

    }

    public void updateApprovalManager(final ApprovalManager aprovalmanager)
    {
        assert aprovalmanager != null;
        approvalManagerDAO.flush();
    }
}