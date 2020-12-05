package com.se2.easypc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.se2.easypc.controller.BuildController;
import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.data_access.model.CPU;
import com.se2.easypc.data_access.model.Case;
import com.se2.easypc.data_access.model.Cooling;
import com.se2.easypc.data_access.model.GPU;
import com.se2.easypc.data_access.model.Motherboard;
import com.se2.easypc.data_access.model.PowerSupply;
import com.se2.easypc.data_access.model.RAM;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.pojo.BuildPOJO;
import com.se2.easypc.service.BuildService;
import com.se2.easypc.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class BuildControllerTests {

    @InjectMocks
    private BuildController buildController;

    @Mock
    private BuildService buildService;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBuildsByUser() {
        User testUser = new User();
        testUser.setUsername("testUser");
        Build build = new Build();
        build.setUser(testUser);
        Case caseObj = new Case();
        caseObj.setIdCase(1L);
        build.setCaseObj(caseObj);
        Cooling cooling = new Cooling();
        cooling.setIdCooling(1L);
        build.setCooling(cooling);
        CPU cpu = new CPU();
        cpu.setIdCPU(1L);
        build.setCpu(cpu);
        GPU gpu = new GPU();
        gpu.setIdGPU(1L);
        build.setGPU(gpu);
        Motherboard motherboard = new Motherboard();
        motherboard.setIdMotherboard(1L);
        build.setMotherboard(motherboard);
        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setIdPowerSupply(1L);
        build.setPowerSupply(powerSupply);
        RAM ram = new RAM();
        ram.setIdRAM(1L);
        build.setRam(ram);

        List <Build> userBuilds = Collections.singletonList( build );
        testUser.setBuilds(userBuilds);

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("testUser");
        when(userService.findByUsername("testUser")).thenReturn(testUser);
        List<BuildPOJO> builds = new ArrayList<>();
        for (Build b : testUser.getBuilds()){
            builds.add(new BuildPOJO(b));
        }
        when(buildService.getBuildsByUser(testUser)).thenReturn(builds);

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("0.0.0.0");

        List<BuildPOJO> buildPOJOs = buildController.getBuildsByUser(request);

        verify(userService).findByUsername("testUser");
        verify(buildService).getBuildsByUser(testUser);
        verify(request).getRemoteAddr();

        assertEquals( builds , buildPOJOs );
    }
}
