import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 15995,
  login: 'I1CFBQ',
};

export const sampleWithPartialData: IUser = {
  id: 29636,
  login: '8if',
};

export const sampleWithFullData: IUser = {
  id: 1269,
  login: 'aDX@qmlw\\ZZNzi\\cixZLt\\.N2Q8q2',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
