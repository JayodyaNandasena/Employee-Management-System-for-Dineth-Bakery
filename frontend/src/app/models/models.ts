export interface LoginRequest {
    username : string,
    password : string
}

export interface EmployeeRead {
    employeeId : string,
    firstName : string,
    lastName : string,
    nic : string,
    dob : Date
    profilePicture : string,
    hiredDate : Date,
    address : string,
    email : string,
    gender : string,
    branchName : string,
    jobRoleTitle : string,
    account: {
        username: string,
        password: string,
        isManager: boolean
    }
}